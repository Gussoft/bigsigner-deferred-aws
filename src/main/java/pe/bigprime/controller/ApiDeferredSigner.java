package pe.bigprime.controller;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.util.Base64;
import pe.bigprime.utils.DynamoUtil;
import pe.bigprime.utils.SignatureOperations;

import java.util.ArrayList;
import java.util.List;

public class ApiDeferredSigner implements RequestHandler<List<BigSinerHashRequest>, BigSignerhashResponse> {

    @Override
    public BigSignerhashResponse handleRequest(List<BigSinerHashRequest> bigSinerHashRequests, Context context) {
        ArrayList<BigSinerHashRequest> hashJsonArrayList = new ArrayList<>();
        BigSignerhashResponse bigSignerhashResponse = new BigSignerhashResponse();
        bigSinerHashRequests.forEach(bigSignerElement ->{
            SignatureOperations signatureOperations =  new SignatureOperations();
            try{
                String signHashKms = signatureOperations.signHashKms(Base64.decode(bigSignerElement.getHash()));
                bigSignerElement.setSignedHash(signHashKms);

                //Guardar el signProcess en DynamoBD
                DynamoUtil dyno = new DynamoUtil();
                dyno.getDynamo(bigSignerElement.getHash(), bigSignerElement.getSignedHash());
                bigSignerhashResponse.setStatus("Ok");
            }catch (Exception e){
                e.printStackTrace();
                bigSignerElement.setSignedHash(e.getMessage());
            }
            hashJsonArrayList.add(bigSignerElement);
            bigSignerhashResponse.setHash(bigSignerElement.getHash());
            bigSignerhashResponse.setSignedHash(bigSignerElement.getSignedHash());
        });

        return bigSignerhashResponse;

    }
}
