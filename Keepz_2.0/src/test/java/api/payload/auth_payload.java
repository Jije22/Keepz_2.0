package api.payload;

public class auth_payload {

    String countryCode;
    String otphash;
    String phone;
    String smsType;
    int code;
    String deviceToken;
    String mobileName;
    String mobileOS;
    String userSMSId;
    String birthDate;
    String iban;
    String name;
    String lastname;
    String personalNumber;
    String userType;

    public String getOtphash() {
        return otphash;
    }

    public void setOtphash(String otphash) {
        this.otphash = otphash;
    }

    public String  getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSmsType() {
        return smsType;
    }

    public void setSmsType(String smsType) {
        this.smsType = smsType;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public String getMobileOS() {
        return mobileOS;
    }

    public void setMobileOS(String mobileOS) {
        this.mobileOS = mobileOS;
    }

    public String getUserSMSId() {
        return userSMSId;
    }

    public void setUserSMSId(String userSMSId) {
        this.userSMSId = userSMSId;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String  getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }


}
