package pe.bigprime.utils;

import java.util.Arrays;
import java.util.Map;

public class VisualSigMapper {
    private String vis_sig_x;
    private String vis_sig_y;
    private String vis_sig_width;
    private String vis_sig_height;
    private String vis_sig_text;
    private String vis_sig_page;
    private String vis_sig_graphic;
    private String vis_sig_text_size;
    private String serial;
    private String path;

    public VisualSigMapper(Map<String, String[]> stringMap) {
        this.setVis_sig_x(Arrays.toString(stringMap.get("vis_sig_x")));
        this.setVis_sig_y(Arrays.toString(stringMap.get("vis_sig_y")));
        this.setVis_sig_width(Arrays.toString(stringMap.get("vis_sig_width")));
        this.setVis_sig_height(Arrays.toString(stringMap.get("vis_sig_height")));
        this.setVis_sig_text(Arrays.toString(stringMap.get("vis_sig_text")));
        this.setVis_sig_page(Arrays.toString(stringMap.get("vis_sig_page")));
        this.setVis_sig_graphic(Arrays.toString(stringMap.get("vis_sig_graphic")));
        this.setVis_sig_text_size(Arrays.toString(stringMap.get("vis_sig_text_size")));
        this.setSerial(Arrays.toString(stringMap.get("serial")));
        this.setPath(Arrays.toString(stringMap.get("path")));
    }

    public int getVis_sig_text_size() {
        return Integer.parseInt(vis_sig_text_size);
    }

    public void setVis_sig_text_size(String vis_sig_text_size) {
        this.vis_sig_text_size = (vis_sig_text_size != null && !vis_sig_text_size.equals("null")) ? vis_sig_text_size.replace("[", "").replace("]", "") : "6";
    }

    public String getVis_sig_x() {
        return vis_sig_x;
    }

    public int getVis_sig_int_x() {
        return (int) Double.parseDouble(vis_sig_x);
    }

    public void setVis_sig_x(String vis_sig_x) {
        this.vis_sig_x = (vis_sig_x != null && !vis_sig_x.equals("null")) ? vis_sig_x.replace("[", "").replace("]", "") : "";
    }

    public String getVis_sig_y() {
        return vis_sig_y;
    }

    public int getVis_sig_int_y() {
        return Integer.parseInt(vis_sig_y);
    }

    public void setVis_sig_y(String vis_sig_y) {
        this.vis_sig_y = vis_sig_y != null && !vis_sig_y.equals("null") ? vis_sig_y.replace("[", "").replace("]", "") : "";
    }

    public int getVis_sig_width() {
        return (int) Double.parseDouble(vis_sig_width);
    }

    public void setVis_sig_width(String vis_sig_width) {
        this.vis_sig_width = vis_sig_width != null && !vis_sig_width.equals("null") ? vis_sig_width.replace("[", "").replace("]", "") : "";
    }

    public int getVis_sig_height() {
        return Integer.parseInt(vis_sig_height);
    }

    public void setVis_sig_height(String vis_sig_height) {
        this.vis_sig_height = vis_sig_height != null && !vis_sig_height.equals("null") ? vis_sig_height.replace("[", "").replace("]", "") : "";
    }

    public String getVis_sig_text() {
        return vis_sig_text;
    }

    public void setVis_sig_text(String vis_sig_text) {
        this.vis_sig_text = vis_sig_text != null ? vis_sig_text.replace("[", "").replace("]", "") : "";
    }

    public String getVis_sig_page() {
        return vis_sig_page;
    }

    public void setVis_sig_page(String vis_sig_page) {
        this.vis_sig_page = vis_sig_page != null && !vis_sig_page.equals("null") ? vis_sig_page.replace("[", "").replace("]", "") : "";
    }

    public String getVis_sig_graphic() {
        return vis_sig_graphic;
    }

    public void setVis_sig_graphic(String vis_sig_graphic) {
        this.vis_sig_graphic = vis_sig_graphic != null && !vis_sig_graphic.equals("null") ? vis_sig_graphic.replace("[", "").replace("]", "") : "";
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial != null && !serial.equals("null") ? serial.replace("[", "").replace("]", "") : "";
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path != null && !path.equals("null") ? path.replace("[", "").replace("]", "") : "";
    }
}
