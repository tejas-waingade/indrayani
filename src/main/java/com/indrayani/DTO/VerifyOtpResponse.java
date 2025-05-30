package com.indrayani.DTO;

public class VerifyOtpResponse {

	private String message;
	private Data data;

	public VerifyOtpResponse() {

	}

	public VerifyOtpResponse(String message, Data data) {
		this.message = message;
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public static class Data {
		private String token;
		private Long user_id;

		public Data() {

		}

		public Data(String token, Long user_id) {
			this.token = token;
			this.user_id = user_id;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public Long getUser_id() {
			return user_id;
		}

		public void setUser_id(Long user_id) {
			this.user_id = user_id;
		}

	}

}
