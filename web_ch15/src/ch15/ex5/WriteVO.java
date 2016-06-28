package ch15.ex5;


import java.sql.Timestamp;

public class WriteVO{
	private int group_id;
	private int msg_id;
	private int parent_id;
	private String author;
	private String email;
	private String title;
	private String content;
	private String passwd;
	private String imageFile;
	private Timestamp  writeday;
	
	public WriteVO() {
	}

	public WriteVO(int group_id,int msg_id, int parent_id, String author, String email, String title, String content,
			String passwd, Timestamp writeday) {
		this.group_id = group_id;
		this.msg_id = msg_id;
		this.parent_id = parent_id;
		this.author = author;
		this.email = email;
		this.title = title;
		this.content = content;
		this.passwd = passwd;
		this.writeday = writeday;
	}

	
	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public int getMsg_id() {
		return msg_id;
	}

	public void setMsg_id(int msg_id) {
		this.msg_id = msg_id;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	public Timestamp getWriteday() {
		return writeday;
	}

	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}

	


}//end class