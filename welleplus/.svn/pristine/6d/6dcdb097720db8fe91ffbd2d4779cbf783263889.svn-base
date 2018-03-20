package com.welleplus.aop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.welleplus.result.Result;

@Component
@Aspect
public class ControllerAop {
	private final String POINTCUT = "execution( * com.welleplus.controller.*Controller.*(..) )";
	
	@Pointcut(POINTCUT)
	private void pointcut(){}
	
	@AfterThrowing(value=POINTCUT,throwing="e")
	public void afterException(Throwable e){
//		Result result = new Result();
//		result.setState(false);
//		result.setMessage("操作失败");
//		System.out.println("-----------------------------------------------------------------");
//		
//		return result;
		
		System.out.println(e.getMessage());
		String message = e.getMessage();
		if("phonehaved".equals(message)){
			writeContent("电话号码已存在!");
		}else if("equiphaved".equals(message)){
			writeContent("设备号码已存在!");
		}else if("nameempty".equals(message)){
			writeContent("姓名不能为空!");
		}else{
			writeContent("操作失败,请稍后再试");
		}
		
	}
	
	private void writeContent(String content) {
		  HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
		  response.reset();
		  response.setCharacterEncoding("UTF-8");
		  response.setHeader("Content-Type", "text/plain;charset=UTF-8");
		  response.setHeader("icop-content-type", "exception");
		  PrintWriter writer = null;
		  try {
			  writer = response.getWriter();
		  } catch (IOException e) {
			  e.printStackTrace();
		  }
		  writer.print(content);
		  writer.flush();
		  writer.close();
	}

}
