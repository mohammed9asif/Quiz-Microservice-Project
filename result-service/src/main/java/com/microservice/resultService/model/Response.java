package com.microservice.resultService.model;

public class Response {

		private int questionId;
		private int	user_input;
		
		public Response() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Response(int questionId, int user_input) {
			super();
			this.questionId = questionId;
			this.user_input = user_input;
		}
		public int getQuestionId() {
			return questionId;
		}
		public void setQuestionId(int questionId) {
			this.questionId = questionId;
		}
		public int getUser_input() {
			return user_input;
		}
		public void setUser_input(int user_input) {
			this.user_input = user_input;
		}
		
}
