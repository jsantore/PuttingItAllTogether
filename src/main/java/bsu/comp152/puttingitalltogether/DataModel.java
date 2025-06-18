package bsu.comp152.puttingitalltogether;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataModel {
    public static final String API_LOC = "http://universities.hipolabs.com/search?name=";
    private HttpClient dataClient;
    private String dataURL;

    public DataModel(String dataURL) {
        this.dataClient = HttpClient.newHttpClient();
        this.dataURL = dataURL;
    }

    public UniversityData[] getData() {
        var httpRequestBuilder = HttpRequest.newBuilder();
        var request = httpRequestBuilder.uri(java.net.URI.create(dataURL)).build();
        HttpResponse<String> response = null;
        try {
            response = dataClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            System.err.println("Error connecting to data source");
            e.printStackTrace();
            System.exit(1);
        } catch (InterruptedException e) {
            System.err.println("Error - connection interrupted");
            e.printStackTrace();
            System.exit(1);
        }
        var data = response.body();
        var dataParser = new ObjectMapper();
        UniversityData[] universityData = null;
        try {
            universityData = dataParser.readValue(data, UniversityData[].class);
        } catch (JsonMappingException e) {
            System.err.println("Error parsing data"+" "+e.getMessage());
        } catch (JsonProcessingException e) {
            System.err.println("Error processing data"+" "+e.getMessage());
        }
        return universityData;
    }

    static class UniversityData {
        @JsonProperty("state-province")
        private String stateProvince;
        @JsonProperty("name")
        private String name;
        @JsonProperty("alpha_two_code")
        private String alphaTwoCode;
        @JsonProperty("web_pages")
        private List<String> webPages;
        @JsonProperty("domains")
        private List<String> domains;
        @JsonProperty("country")
        private String country;

        public String getName() {
            return name;
        }
        public String getCountry() {
            return country;
        }
        public String getStateProvince() {
            return stateProvince;
        }
        public String getAlphaTwoCode() {
            return alphaTwoCode;
        }
        public String getStateProvince(){
            return stateProvince;
        }
        public String getFirstWebPage() {
            if (webPages.size() > 0) {
                return webPages.get(0);
            } else {
                return "";
            }
        }
        public List<String> getDomains(){
            return domains;
        }



        @Override
        public String toString() {
            return name + " " + country;
        }
    }
}
