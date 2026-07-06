package com.tcs.ParsalManagement.Models;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "Bookings")
public
class Bookings {
	@Id
	@Column(name = "bookingId")
	private String bookingId; 
	@Column(name = "customerId")
	private String customerId; 
	@Column(name = "customerName")
	private String customerName; 
	@Column(name = "customerAddr")
	private String customerAddr; 
	@Column(name = "recName")
	private String recName;
	@Column(name = "recAddress")
	private String recAddress;
	@Column(name = "recPin")
	private String recPin;
	@Column(name = "recMobile")
	private String recMobile;
	@Column(name = "content")
	private String content;
	@Column(name = "deliveryType")
	private String deliveryType;
	@Column(name = "packingPref")
	private String packingPref;
	@Column(name = "status")
	private String status;
	@Column(name = "pickupTime")
	private Timestamp pickupTime;
	@Column(name = "dropoffTime")
	private Timestamp dropoffTime; 
	@Column(name = "paymentTime")
	private Timestamp paymentTime;
	@Column(name = "weight")
	private double weight;
	@Column(name = "cost")
	private double cost;

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddr() {
		return customerAddr;
	}

	public void setCustomerAddr(String customerAddr) {
		this.customerAddr = customerAddr;
	}

	public String getRecName() {
		return recName;
	}

	public void setRecName(String recName) {
		this.recName = recName;
	}

	public String getRecAddress() {
		return recAddress;
	}

	public void setRecAddress(String recAddress) {
		this.recAddress = recAddress;
	}

	public String getRecPin() {
		return recPin;
	}

	public void setRecPin(String recPin) {
		this.recPin = recPin;
	}

	public String getRecMobile() {
		return recMobile;
	}

	public void setRecMobile(String recMobile) {
		this.recMobile = recMobile;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public String getPackingPref() {
		return packingPref;
	}

	public void setPackingPref(String packingPref) {
		this.packingPref = packingPref;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(Timestamp pickupTime) {
		this.pickupTime = pickupTime;
	}

	public Timestamp getDropoffTime() {
		return dropoffTime;
	}

	public void setDropoffTime(Timestamp dropoffTime) {
		this.dropoffTime = dropoffTime;
	}

	public Timestamp getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(Timestamp paymentTime) {
		this.paymentTime = paymentTime;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	

	public Bookings(String bId, String cId, String cName, String cAddr, String rName, String rAddr, String rPin, String rMob, double w, String desc, String type, String pack) {
		this.bookingId = bId;
		this.customerId = cId;
		this.customerName = cName;
		this.customerAddr = cAddr;
		this.recName = rName;
		this.recAddress = rAddr;
		this.recPin = rPin;
		this.recMobile = rMob;
		this.weight = w;
		this.content = desc;
		this.deliveryType = type;
		this.packingPref = pack;
		this.status = "Booked";
		this.cost = w * 1.25;
		this.paymentTime = new Timestamp(System.currentTimeMillis());
		this.pickupTime = null;
		this.dropoffTime = null;
	}
	

	@Override
	public String toString() {
		return "Bookings [bookingId=" + bookingId + ", customerId=" + customerId + ", customerName=" + customerName
				+ ", customerAddr=" + customerAddr + ", recName=" + recName + ", recAddress=" + recAddress + ", recPin="
				+ recPin + ", recMobile=" + recMobile + ", content=" + content + ", deliveryType=" + deliveryType
				+ ", packingPref=" + packingPref + ", status=" + status + ", pickupTime=" + pickupTime
				+ ", dropoffTime=" + dropoffTime + ", paymentTime=" + paymentTime + ", weight=" + weight + ", cost="
				+ cost + "]";
	}
	
	public Bookings() {
	}

	public Bookings(String bookingId, String customerId, String customerName, String customerAddr, String recName,
			String recAddress, String recPin, String recMobile, String content, String deliveryType, String packingPref,
			String status, Timestamp pickupTime, Timestamp dropoffTime, Timestamp paymentTime, double weight,
			double cost) {
		
		super();
		this.bookingId = bookingId;
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddr = customerAddr;
		this.recName = recName;
		this.recAddress = recAddress;
		this.recPin = recPin;
		this.recMobile = recMobile;
		this.content = content;
		this.deliveryType = deliveryType;
		this.packingPref = packingPref;
		this.status = status;
		this.pickupTime = pickupTime;
		this.dropoffTime = dropoffTime;
		this.paymentTime = paymentTime;
		this.weight = weight;
		this.cost = cost;
	}
	
	
	
}