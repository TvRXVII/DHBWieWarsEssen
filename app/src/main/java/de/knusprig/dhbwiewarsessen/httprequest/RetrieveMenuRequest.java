package de.knusprig.dhbwiewarsessen.httprequest;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RetrieveMenuRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "https://dhbwwe.heliohost.org/RetrieveMenu.php";
    private Map<String, String> params;

    public RetrieveMenuRequest(String id, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("id", id);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
