package com.first.app.util;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.DatatypeConverter;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class RestUtil {
	@SuppressWarnings("rawtypes")
	public static Object postService(String url, MultiValueMap pars, Class classData) {
		return prosesService(url, pars, classData, HttpMethod.POST, null, null);
	}

	@SuppressWarnings("rawtypes")
	public static Object getService(String url, MultiValueMap pars, Class classData) {
		return prosesService(url, pars, classData, HttpMethod.GET, null, null);
	}

	@SuppressWarnings("rawtypes")
	public static Object postService(String url, MultiValueMap pars, Class classData, String user, String password) {
		return prosesService(url, pars, classData, HttpMethod.POST, user, password);
	}

	@SuppressWarnings("rawtypes")
	public static Object postServiceWithMediaType(String url, MultiValueMap pars, Class classData, String user,
			String password, MediaType mediaType) {
		return postFormData(url, pars, classData, user, password, mediaType);
	}

	@SuppressWarnings("rawtypes")
	public static Object putService(String url, MultiValueMap pars, Class classData, String user, String password) {
		return prosesService(url, pars, classData, HttpMethod.PUT, user, password);
	}

	@SuppressWarnings("rawtypes")
	public static Object postJsonService(String url, MultiValueMap pars, Class classData, String user,
			String password) {
		return postJsonData(url, pars, classData, user, password);
	}

	@SuppressWarnings("rawtypes")
	public static Object postJsonService(String url, MultiValueMap pars, Class classData) {
		return postJsonData(url, pars, classData, null, null);
	}

	@SuppressWarnings("rawtypes")
	public static Object postJsonServiceMap(String url, Map pars, Class classData, String user, String password) {
		return postJsonDataMap(url, pars, classData, user, password);
	}

	@SuppressWarnings("rawtypes")
	public static Object postJsonServiceMap(String url, Map pars, Class classData) {
		return postJsonDataMap(url, pars, classData, null, null);
	}

	@SuppressWarnings("rawtypes")
	public static Object getService(String url, MultiValueMap pars, Class classData, String user, String password) {
		return prosesService(url, pars, classData, HttpMethod.GET, user, password);
	}

	@SuppressWarnings("rawtypes")
	public static Object getService(String url, Map<String, Object> pars, Class classData, String user,
			String password) {
		return getData(url, pars, classData, user, password);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static Object prosesService(String url, MultiValueMap pars, Class classData, HttpMethod method, String user,
			String password) {
		if (method.equals(HttpMethod.POST)) {
			return postFormData(url, pars, classData, user, password);
		} else if (method.equals(HttpMethod.GET)) {
			return getData(url, pars, classData, user, password);
		} else if (method.equals(HttpMethod.PUT)) {
			return putData(url, pars, classData, user, password);
		} else {
			return null;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static Object postFormData(String url, MultiValueMap pars, Class classData, String user, String password) {
		HttpHeaders headers = new HttpHeaders();

		if (user != null && password != null) {
			String plainCreds = user + ":" + password;
			byte[] plainCredsBytes = plainCreds.getBytes();
			String base64Creds = DatatypeConverter.printBase64Binary(plainCredsBytes);// Base64.encodeBase64(plainCredsBytes);
			headers.add("Authorization", "Basic " + base64Creds);
		}
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);

		HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(pars,
				headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity response = restTemplate.exchange(url, HttpMethod.POST, request, classData);
		return response.getBody();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static Object postFormData(String url, MultiValueMap pars, Class classData, String user, String password,
			MediaType mediaType) {
		HttpHeaders headers = new HttpHeaders();

		if (user != null && password != null) {
			String plainCreds = user + ":" + password;
			byte[] plainCredsBytes = plainCreds.getBytes();
			String base64Creds = DatatypeConverter.printBase64Binary(plainCredsBytes);// Base64.encodeBase64(plainCredsBytes);
			headers.add("Authorization", "Basic " + base64Creds);
		}
		headers.setContentType(mediaType);

		HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(pars,
				headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity response = restTemplate.exchange(url, HttpMethod.POST, request, classData);
		return response.getBody();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static Object putData(String url, MultiValueMap pars, Class classData, String user, String password) {
		HttpHeaders headers = new HttpHeaders();

		if (user != null && password != null) {
			String plainCreds = user + ":" + password;
			byte[] plainCredsBytes = plainCreds.getBytes();
			String base64Creds = DatatypeConverter.printBase64Binary(plainCredsBytes);// Base64.encodeBase64(plainCredsBytes);
			headers.add("Authorization", "Basic " + base64Creds);
		}
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(pars,
				headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity response = restTemplate.exchange(url, HttpMethod.PUT, request, classData);
		return response.getBody();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static Object postJsonData(String url, MultiValueMap pars, Class classData, String user, String password) {
		HttpHeaders headers = new HttpHeaders();

		if (user != null && password != null) {
			String plainCreds = user + ":" + password;
			byte[] plainCredsBytes = plainCreds.getBytes();
			String base64Creds = DatatypeConverter.printBase64Binary(plainCredsBytes);// Base64.encodeBase64(plainCredsBytes);
			headers.add("Authorization", "Basic " + base64Creds);
		}

		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(pars,
				headers);
		RestTemplate restTemplate = new RestTemplate();
		Object response = restTemplate.postForObject(url, request, classData); // .postForEntity(url,
																				// request,
																				// classData);//
																				// restTemplate.exchange(url,
																				// HttpMethod.POST,
																				// request,
																				// classData);
		return response;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static Object postJsonDataMap(String url, Map pars, Class classData, String user, String password) {
		HttpHeaders headers = new HttpHeaders();

		if (user != null && password != null) {
			String plainCreds = user + ":" + password;
			byte[] plainCredsBytes = plainCreds.getBytes();
			String base64Creds = DatatypeConverter.printBase64Binary(plainCredsBytes);// Base64.encodeBase64(plainCredsBytes);
			headers.add("Authorization", "Basic " + base64Creds);
		}

		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Map<String, Object>> request = new HttpEntity<Map<String, Object>>(pars, headers);
		RestTemplate restTemplate = new RestTemplate();
		Object response = restTemplate.postForObject(url, request, classData); // .postForEntity(url,
																				// request,
																				// classData);//
																				// restTemplate.exchange(url,
																				// HttpMethod.POST,
																				// request,
																				// classData);
		return response;
	}

	// private static Object getData(String url,MultiValueMap pars,Class
	// classData,String user,String password){
	// HttpHeaders headers = new HttpHeaders();
	//
	// if(user!=null && password!=null){
	// String plainCreds = user+":"+password;
	// byte[] plainCredsBytes = plainCreds.getBytes();
	// String base64Creds =
	// DatatypeConverter.printBase64Binary(plainCredsBytes);//Base64.encodeBase64(plainCredsBytes);
	// headers.add("Authorization", "Basic " + base64Creds);
	// }
	//// headers.setContentType(MediaType.APPLICATION_JSON);
	// HttpEntity<String> request = new HttpEntity<String>(headers);
	//
	// RestTemplate restTemplate = new RestTemplate();
	// String newUrl=convert_map_to_uri_spring(url,pars);
	// System.out.println("get:"+newUrl);
	// ResponseEntity response = restTemplate.exchange(newUrl, HttpMethod.GET,
	// request, classData);
	// response.getHeaders();
	// return response.getBody();
	// }

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static Object getData(String url, Map<String, Object> pars, Class classData, String user, String password) {
		HttpHeaders headers = new HttpHeaders();

		if (user != null && password != null) {
			String plainCreds = user + ":" + password;
			byte[] plainCredsBytes = plainCreds.getBytes();
			String base64Creds = DatatypeConverter.printBase64Binary(plainCredsBytes);// Base64.encodeBase64(plainCredsBytes);
			headers.add("Authorization", "Basic " + base64Creds);
		}
		// headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<String>(headers);

		RestTemplate restTemplate = new RestTemplate();
		String newUrl = convert_map_to_uri(url, pars);
		System.out.println("get:" + newUrl);
		ResponseEntity response = restTemplate.exchange(newUrl, HttpMethod.GET, request, classData);
		response.getHeaders();
		return response.getBody();
	}

	@SuppressWarnings("static-access")
	public static String convert_map_to_uri_spring(String url, MultiValueMap<String, Object> pars) {
		UriComponentsBuilder builder = UriComponentsBuilder.newInstance().fromHttpUrl(url);
		if (pars != null) {
			for (Entry<String, List<Object>> entry : pars.entrySet()) {
				builder.queryParam(entry.getKey(), entry.getValue().get(0));
			}
			return builder.build().toString();
		} else {
			return url;
		}
	}

	@SuppressWarnings("static-access")
	public static String convert_map_to_uri(String url, Map<String, Object> pars) {
		UriComponentsBuilder builder = UriComponentsBuilder.newInstance().fromHttpUrl(url);
		if (pars != null) {
			for (Entry<String, Object> entry : pars.entrySet()) {
				builder.queryParam(entry.getKey(), entry.getValue());
			}
			return builder.build().toString();
		} else {
			return url;
		}
	}

	// ===================== tes service =====================
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object postDataUrlEncoded(String url, MultiValueMap pars, Class classData, String user,
			String password) {
		HttpHeaders headers = new HttpHeaders();

		if (user != null && password != null) {
			String plainCreds = user + ":" + password;
			byte[] plainCredsBytes = plainCreds.getBytes();
			String base64Creds = DatatypeConverter.printBase64Binary(plainCredsBytes);// Base64.encodeBase64(plainCredsBytes);
			headers.add("Authorization", "Basic " + base64Creds);
		}
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(pars,
				headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity response = restTemplate.exchange(url, HttpMethod.POST, request, classData);
		return response.getBody();
	}

}
