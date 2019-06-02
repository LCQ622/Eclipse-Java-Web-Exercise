package cn.mcandoird.service;

import java.io.IOException;

import cn.mcandoird.page.Page;

public interface PageService {
	public Page showPage(int start ,int size)throws IOException ;
}
