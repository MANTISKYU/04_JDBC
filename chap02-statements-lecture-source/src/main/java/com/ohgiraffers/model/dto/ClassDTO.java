package com.ohgiraffers.model.dto;

public class ClassDTO {


    private int student_no;
    private String student_name;
    private String gender;
    private String github_id;
    private String mbti;
    private int subject_no;


    public ClassDTO() {
    }

    public ClassDTO(int student_no, String student_name, String gender, String github_id, String mbti, int subject_no) {
        this.student_no = student_no;
        this.student_name = student_name;
        this.gender = gender;
        this.github_id = github_id;
        this.mbti = mbti;
        this.subject_no = subject_no;
    }

    public int getStudent_no() {
        return student_no;
    }

    public void setStudent_no(int student_no) {
        this.student_no = student_no;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGithub_id() {
        return github_id;
    }

    public void setGithub_id(String github_id) {
        this.github_id = github_id;
    }

    public String getMbti() {
        return mbti;
    }

    public void setMbti(String mbti) {
        this.mbti = mbti;
    }

    public int getSubject_no() {
        return subject_no;
    }

    public void setSubject_no(int subject_no) {
        this.subject_no = subject_no;
    }

    @Override
    public String toString() {
        return "ClassDTO{" +
                "student_no=" + student_no +
                ", student_name='" + student_name + '\'' +
                ", gender='" + gender + '\'' +
                ", github_id='" + github_id + '\'' +
                ", mbti='" + mbti + '\'' +
                ", subject_no=" + subject_no +
                '}';
    }
}
