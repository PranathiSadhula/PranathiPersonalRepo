package api.controller;

import api.controller.response.ApiResponseValidator;

/*
 * Author : Pranathi Sadhula
 * ApiQAController.java is an interface containing method declaration
 * 
 *//**
 * The Interface ApiQAController.
 */
public interface ApiQAController {

	/**
	 * Gets the response.
	 *
	 * @return the response: ApiResponseValidator
	 */
	public ApiResponseValidator getResponse(String reqAdType,String reqUr) ;
}
