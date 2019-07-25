package com.yy.config;

public class AlipayConfig {
	// 商户appid
	public static String APPID ="2016100100637047";
	// 私钥 pkcs8格式的
	public static String RSA_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCJ2SGLW0wq0fRWIbwwwXYz8tT1Ew2cPgyU8Uzb4kS0OPITPJGt34ry5YEBYqrvz5sKUHMepg0hqkrM/zk74xfl3eAa/Z2cWnC4N0HJdh8fVP4gLvvuEECwoyK2FShElo4PNnuSP/w6YoevHi1F9YlocbcWTsx0/IGqT/xMEjltQcWHwUZHWUpWUzcatbER43LN7EuwOeRcDT99izdzlO98MdBVghpFSfMJ+y/vchGn4RGkCImGKxRhLFEvT0GoYHjWaXddjo6dIV3RtXkkt/r8tMJH69cGll7CjR9SDUyA9Fwu0dL1k0d3tN7p7HQPsz9Wh46+H+KzZ/59yzYRuFQlAgMBAAECggEAX28Ppici6FJK0oawfyCw8O4hOTpjpdPfag5Uo7ZW0l7KWT8JrFKjI954HbltlnEoaU+hI4radIAtIRdhTHDATsf5KzaCM4j5mM/In+1DRrHU7fsZN4vQ/XkzwtOK+VEyMJ4LlwjtWo50WWyO82w2ITT5CFyteCCItJyDkzbawyRIFlr89pIDSKnxtvdq9lOdkzrzfpB7WbBbyOzXUaWfaCl4Ih7MGzK+id+jcA7xW2srneufj7BwKmoKEQ2Ecde8JCNzbxrM2JJBgb7qbnNZvli8mAxDjjWyt3vnmXYQFHo9wWmqXgC9f/eK2o9c2p36N64MoWcdQV5+iCzozwXM0QKBgQDnS/JpbW0VsJEN4J4zLEajfeQ9Vwe+hnzqjIgBxtipoeE0qcCajekhfqryTjVLUFnVTo/NxNgh4RPW3V34Qp2gMLOMUpw0n1T+p/WVyuSMkeXM+OfUCcaZneIKXfJjupeHMi3S8IGer1HR763thiCXCZurRN9RSelYn1pyxdHRSwKBgQCYkiO/nZn/uw5/najkk3JnOyEuufMC8/F7o9h8NhuH1Z2W1+3stphCvyoo0qwwmx6Q8FgirHKcxGwMTSkGDiW1thNPnkl31MXh+RDdVv6mWy08IC4grKO1z+31fBLpQc1H16dAUhoaWI09ILwDLLsNG1X7zlx+UOVcJL77PtF6TwKBgHrbWXDsoePCfNoNNJrj6sWO6jw2zTNDhnijmt6uu4knJlNt05OEy49yE+VO63oMvRrTdwkKhO9B+eLIhNCIuedL1yMzAivlciUuHAGr2shb+t9sWt/DLY2NUnLFQin9A93ZJoQEIiWi5GgJ0q3277qqbNiFZcVs6Bid1FJghzmPAoGAN0yw3GD5UnGwXZz9fGvdCYGrE06ewDE/E7tdWhgafm90wRneyO+d3IOBem5xruRqfco/h8HNgPjI2OSWu/Ugwe4OrcsHggGC/9bQwAkqH43opWRck8c/R0ToURP5nsYU67dEjdG0WFxERSW6P8RUv/lqfuxbJgWYPH+tIU+xiY0CgYBr1tauPojHanA0N+S3inoaL1R81AcU5/hhf2TLJ/O/AoFL8DKuEeLYAWNNMO/g91KReRMXdNkMYpFAkmrTNhiYhJRaJYv3YDmBgeBfUV7zhJROVe2kGf5T9EYiHyN4qD8syxsFDEtmR1Vp5OyjFY0fTsQYrwjBzoQ/VKorNwsYRQ==";
	// 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://www.baidu.com";
	// 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
	public static String return_url = "http://www.baidu.com";
	// 请求网关地址
	public static String URL = "https://openapi.alipaydev.com/gateway.do";
	// 编码
	public static String CHARSET = "UTF-8";
	// 返回格式
	public static String FORMAT = "json";
	// 支付宝公钥
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAidkhi1tMKtH0ViG8MMF2M/LU9RMNnD4MlPFM2+JEtDjyEzyRrd+K8uWBAWKq78+bClBzHqYNIapKzP85O+MX5d3gGv2dnFpwuDdByXYfH1T+IC777hBAsKMithUoRJaODzZ7kj/8OmKHrx4tRfWJaHG3Fk7MdPyBqk/8TBI5bUHFh8FGR1lKVlM3GrWxEeNyzexLsDnkXA0/fYs3c5TvfDHQVYIaRUnzCfsv73IRp+ERpAiJhisUYSxRL09BqGB41ml3XY6OnSFd0bV5JLf6/LTCR+vXBpZewo0fUg1MgPRcLtHS9ZNHd7Te6ex0D7M/VoeOvh/is2f+fcs2EbhUJQIDAQAB";
	// 日志记录目
	public static String log_path = "d:/log";
	// RSA2
	public static String SIGNTYPE = "RSA2";
}

