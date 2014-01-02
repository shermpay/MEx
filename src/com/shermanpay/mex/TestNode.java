package com.shermanpay.mex;

public class TestNode {
    TestNode left;
    String data;
    TestNode right;

    public TestNode(){}

    public TestNode(String data) {
	this.data = data;
    }

    public TestNode(TestNode left, String data, TestNode right) {
	this.left = left;
	this.data = data;
	this.right = right;
    }

    public String toString() {
	return data;
    }
}
