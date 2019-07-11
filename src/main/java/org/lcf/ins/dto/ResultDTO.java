package org.lcf.ins.dto;

import org.lcf.ins.enums.ErrorEnum;

public class ResultDTO<T> {
	/**成功状态码*/
    public static final int SUCCESS_CODE = ErrorEnum.success.getErrorCode();
    /**失败状态码*/
    public static final int FAIL_CODE = ErrorEnum.failure.getErrorCode();
    
	private int status;

	private String message;

	private T data;

	public ResultDTO() {
	}

	public ResultDTO(int status) {
		this.status = status;
	}

	public ResultDTO(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public ResultDTO(int status, String message, T data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public ResultDTO(T data) {
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@SuppressWarnings("rawtypes")
	public static <T> ResultDTO newSuccess() {
		return new ResultDTO<T>(SUCCESS_CODE, "success");
	}

	@SuppressWarnings("rawtypes")
	public static <T> ResultDTO newSuccess(T data) {
		return new ResultDTO<T>(SUCCESS_CODE, null, data);
	}

	@SuppressWarnings("rawtypes")
	public static <T> ResultDTO newFail() {
		return new ResultDTO<T>(FAIL_CODE);
	}


	@SuppressWarnings("rawtypes")
	public static ResultDTO newFail(String errMsg) {
		return new ResultDTO(FAIL_CODE, errMsg);
	}

	@SuppressWarnings("rawtypes")
	public static <T> ResultDTO newFail(T data) {
		return new ResultDTO<T>(FAIL_CODE, null, data);
	}
}
