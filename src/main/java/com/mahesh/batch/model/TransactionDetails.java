package com.mahesh.batch.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Setter
@Getter
@Table(name = "Transaction_Details")
public class TransactionDetails {

	@Id
	@Column(name = "Series_Reference")
	private String series_reference;
	
	@Column(name = "Period")
	private String period;
	
	@Column(name = "Data_Values")
	private String data_values;
	
	@Column(name = "Suppressed")
	private String suppressed;
	
	@Column(name = "Status")
	private String status;
	
	@Column(name = "Units")
	private String units;
	
	@Column(name = "Magnitude")
	private String magnitude;
	
	@Column(name = "Subject")
	private String subject;
	
	@Column(name = "Groups1")
	private String groups;
	
	@Column(name = "Series_Title_1")
	private String series_title_1;
	
	@Column(name = "Series_Title_2")
	private String series_title_2;
	
	@Column(name = "Series_Title_3")
	private String series_title_3;
	
	@Column(name = "Series_Title_4")
	private String series_title_4;
	
	@Column(name = "Series_Title_5")
	private String series_title_5;

	public String getSeries_reference() {
		return series_reference;
	}

	public void setSeries_reference(String series_reference) {
		this.series_reference = series_reference;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getData_value() {
		return data_values;
	}

	public void setData_value(String data_values) {
		this.data_values = data_values;
	}

	public String getSuppressed() {
		return suppressed;
	}

	public void setSuppressed(String suppressed) {
		this.suppressed = suppressed;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getMagnitude() {
		return magnitude;
	}

	public void setMagnitude(String magnitude) {
		this.magnitude = magnitude;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getGroup() {
		return groups;
	}

	public void setGroup(String groups) {
		this.groups = groups;
	}

	public String getSeries_title_1() {
		return series_title_1;
	}

	public void setSeries_title_1(String series_title_1) {
		this.series_title_1 = series_title_1;
	}

	public String getSeries_title_2() {
		return series_title_2;
	}

	public void setSeries_title_2(String series_title_2) {
		this.series_title_2 = series_title_2;
	}

	public String getSeries_title_3() {
		return series_title_3;
	}

	public void setSeries_title_3(String series_title_3) {
		this.series_title_3 = series_title_3;
	}

	public String getSeries_title_4() {
		return series_title_4;
	}

	public void setSeries_title_4(String series_title_4) {
		this.series_title_4 = series_title_4;
	}

	public String getSeries_title_5() {
		return series_title_5;
	}

	public void setSeries_title_5(String series_title_5) {
		this.series_title_5 = series_title_5;
	}

	public TransactionDetails(String series_reference, String period, String data_value, String suppressed,
			String status, String units, String magnitude, String subject, String group, String series_title_1,
			String series_title_2, String series_title_3, String series_title_4, String series_title_5) {
		super();
		this.series_reference = series_reference;
		this.period = period;
		this.data_values = data_value;
		this.suppressed = suppressed;
		this.status = status;
		this.units = units;
		this.magnitude = magnitude;
		this.subject = subject;
		this.groups = group;
		this.series_title_1 = series_title_1;
		this.series_title_2 = series_title_2;
		this.series_title_3 = series_title_3;
		this.series_title_4 = series_title_4;
		this.series_title_5 = series_title_5;
	}

	public TransactionDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
