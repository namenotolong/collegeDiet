package com.swpu.diet_healthydomain;


import java.sql.Date;

public class Student {
	private Integer id;
	private String s_id;
	private String phone;
	private String sex;
	private String password;
	private String real_name;
	private String school;
	private String grade;
	private String nick_name;
	private String picture;
	private String creation;
	private String modified;
    private int start;
    private int end;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getPicture() {
		return picture;
	}

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCreation() {
        return creation;
    }

    public void setCreation(String creation) {
        this.creation = creation;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    @Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", s_id='" + s_id + '\'' +
				", phone='" + phone + '\'' +
				", sex='" + sex + '\'' +
				", password='" + password + '\'' +
				", real_name='" + real_name + '\'' +
				", school='" + school + '\'' +
				", grade='" + grade + '\'' +
				", nick_name='" + nick_name + '\'' +
				", picture='" + picture + '\'' +
				", creation=" + creation +
				", modified=" + modified +
				'}';
	}
}
