package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class KakaoDto {

	private Long id;
	private String connected_at;
	private Properties properties;
	private Kakao_account kakao_account;
	
	@Data
	public class Properties{
		public String nickname;
		public String profile_image;
		public String thumbnail_image;
	}
	
	@Data
	public class Kakao_account{
		public boolean profile_nickname_needs_agreement;
		public boolean profile_image_needs_agreement;
		public Profile profile;
		public String name;
		public boolean email_needs_agreement;
		public String email;
		public String gender;
		
		public class Profile{
			public String nickname;
			public String thumbnail_image_url;
			public String profile_image_url;
			public boolean is_default_image;
			public boolean is_default_nickname;
		}
	}
}
