package guru.springframework.models;

/**
 * Created by Do My Duyen on 8/19/2017.
 */
public class FakeJmsData {

    private String jmsUsername;
    private String jmsPassword;
    private String jmsUrl;

    public FakeJmsData(String jmsUsername, String jmsPassword, String jmsUrl) {
        this.jmsUsername = jmsUsername;
        this.jmsPassword = jmsPassword;
        this.jmsUrl = jmsUrl;
    }

    public String getJmsUsername() {
        return jmsUsername;
    }

    public void setJmsUsername(String jmsUsername) {
        this.jmsUsername = jmsUsername;
    }

    public String getJmsPassword() {
        return jmsPassword;
    }

    public void setJmsPassword(String jmsPassword) {
        this.jmsPassword = jmsPassword;
    }

    public String getJmsUrl() {
        return jmsUrl;
    }

    public void setJmsUrl(String jmsUrl) {
        this.jmsUrl = jmsUrl;
    }

    @Override
    public String toString() {
        return "FakeJmsData{" +
                "jmsUsername='" + jmsUsername + '\'' +
                ", jmsPassword='" + jmsPassword + '\'' +
                ", jmsUrl='" + jmsUrl + '\'' +
                '}';
    }
}
