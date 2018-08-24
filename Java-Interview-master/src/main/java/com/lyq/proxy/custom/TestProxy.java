package com.lyq.proxy.custom;



public class TestProxy {
public static void main(String[] args) {
	PersonProxy proxy = new PersonProxy();
	Person person = (Person) proxy.getInstance(new ChinaPersonImp());
	person.sayHello();

}
}
