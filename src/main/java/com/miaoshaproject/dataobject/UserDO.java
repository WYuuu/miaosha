package com.miaoshaproject.dataobject;
/**
 * 数据存储，传输数据至UserService,并在UserService中组装模型
 * */
public class UserDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.id
     *
     * @mbg.generated Mon Aug 26 13:36:08 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.name
     *
     * @mbg.generated Mon Aug 26 13:36:08 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.gender
     *
     * @mbg.generated Mon Aug 26 13:36:08 CST 2019
     */
    private Byte gender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.age
     *
     * @mbg.generated Mon Aug 26 13:36:08 CST 2019
     */
    private Integer age;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.telephone
     *
     * @mbg.generated Mon Aug 26 13:36:08 CST 2019
     */
    private String telphone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.regiter_mode
     *
     * @mbg.generated Mon Aug 26 13:36:08 CST 2019
     */
    private String registerMode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.third_party_id
     *
     * @mbg.generated Mon Aug 26 13:36:08 CST 2019
     */
    private String thirdPartyId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.id
     *
     * @return the value of user_info.id
     *
     * @mbg.generated Mon Aug 26 13:36:08 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.id
     *
     * @param id the value for user_info.id
     *
     * @mbg.generated Mon Aug 26 13:36:08 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.name
     *
     * @return the value of user_info.name
     *
     * @mbg.generated Mon Aug 26 13:36:08 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.name
     *
     * @param name the value for user_info.name
     *
     * @mbg.generated Mon Aug 26 13:36:08 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.gender
     *
     * @return the value of user_info.gender
     *
     * @mbg.generated Mon Aug 26 13:36:08 CST 2019
     */
    public Byte getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.gender
     *
     * @param gender the value for user_info.gender
     *
     * @mbg.generated Mon Aug 26 13:36:08 CST 2019
     */
    public void setGender(Byte gender) {
        this.gender = gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.age
     *
     * @return the value of user_info.age
     *
     * @mbg.generated Mon Aug 26 13:36:08 CST 2019
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.age
     *
     * @param age the value for user_info.age
     *
     * @mbg.generated Mon Aug 26 13:36:08 CST 2019
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.telephone
     *
     * @return the value of user_info.telephone
     *
     * @mbg.generated Mon Aug 26 13:36:08 CST 2019
     */
    public String getTelphone() {
        return telphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.telephone
     *
     * @param telphone the value for user_info.telephone
     *
     * @mbg.generated Mon Aug 26 13:36:08 CST 2019
     */
    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.regiter_mode
     *
     * @return the value of user_info.regiter_mode
     *
     * @mbg.generated Mon Aug 26 13:36:08 CST 2019
     */
    public String getRegisterMode() {
        return registerMode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.regiter_mode
     *
     * @param registerMode the value for user_info.regiter_mode
     *
     * @mbg.generated Mon Aug 26 13:36:08 CST 2019
     */
    public void setRegisterMode(String registerMode) {
        this.registerMode = registerMode == null ? null : registerMode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.third_party_id
     *
     * @return the value of user_info.third_party_id
     *
     * @mbg.generated Mon Aug 26 13:36:08 CST 2019
     */
    public String getThirdPartyId() {
        return thirdPartyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.third_party_id
     *
     * @param thirdPartyId the value for user_info.third_party_id
     *
     * @mbg.generated Mon Aug 26 13:36:08 CST 2019
     */
    public void setThirdPartyId(String thirdPartyId) {
        this.thirdPartyId = thirdPartyId == null ? null : thirdPartyId.trim();
    }
}