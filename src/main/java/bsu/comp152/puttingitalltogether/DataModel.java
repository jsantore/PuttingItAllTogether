package bsu.comp152.puttingitalltogether;

import java.net.http.HttpClient;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DataModel {
    public static final String API_LOC = "http://universities.hipolabs.com/search?name=";
    private HttpClient dataClient;

    class UniversityData {
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

        @Override
        public String toString() {
            return "University{" +
                    "stateProvince='" + stateProvince + '\'' +
                    ", name='" + name + '\'' +
                    ", alphaTwoCode='" + alphaTwoCode + '\'' +
                    ", webPages=" + webPages +
                    ", domains=" + domains +
                    ", country='" + country + '\'' +
                    '}';
        }
    }
}
