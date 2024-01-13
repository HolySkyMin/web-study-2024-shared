package hello.servlet.domain.member;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class Model {
    @Getter
    private String viewName;
    private Map<String, String> params;
    @Getter
    private Map<String, Object> models;


    public Model(String view) {
        viewName = view;
        params = new HashMap<>();
        models = new HashMap<>();
    }

    public Model(String view, Map<String, String> paramMap, Map<String, Object> modelMap) {
        viewName = view;
        params = paramMap;
        models = modelMap;
    }

    public void setParameter(String key, String value) {
        params.put(key, value);
    }

    public String getParameter(String key) {
        return params.get(key);
    }

    public void setModel(String key, Object value) {
        models.put(key, value);
    }

    public <T> T getModel(String key) {
        return (T)models.get(key);
    }
}
