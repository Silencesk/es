package com.sishuok.es.bussiness;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


public class StringBuilderTest {

	public static void main(String[] args) {
		Person p = new StringBuilderTest().new Person();
		p.setAge(40);
		p.setSex("man");
		p.setName("dave");
		
		System.out.println(p.toString());
	}
	
	class Person{
		private String name;
		private String sex;
		private int age;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		
		@Override
		public String toString(){
			return ReflectionToStringBuilder.toString(this);
		}
	}

}
