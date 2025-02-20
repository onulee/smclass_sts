package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class KakaoProfile {
	public Long id;
	public String connected_at;
	public Properties properties;
	
	@Data
	public class Properties{
		public String nickname;
		public String profile_image;
		public String thumbnail_image;
	}
	
	public KakaoAccount kakao_account;
	
	@Data
	public class KakaoAccount{
		public boolean profile_nickname_needs_agreement;
		public boolean profile_image_needs_agreement;
		public Profile profile;
		@Data
		public class Profile{
			public String nickname;
			public String thumbnail_image_url;
			public String profile_image_url;
			public boolean is_default_image;
			public boolean is_default_nickname;
		}
		public boolean name_needs_agreement;
		public String name;
		public boolean email_needs_agreement;
		public String email;
		
	}
	
	
	
	
	

}
