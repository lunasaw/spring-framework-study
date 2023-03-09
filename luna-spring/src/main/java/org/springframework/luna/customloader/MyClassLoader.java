package org.springframework.luna.customloader;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

class MyClassLoader extends ClassLoader {

	private final String path;


	MyClassLoader(String path) {
		this.path = path;
	}

	/**
	 * 重写ClassLoader的findClass方法，获取到类的Class对象
	 *
	 * @param name
	 * @return
	 * @throws ClassNotFoundException
	 */
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] byteArrayFromClassName = getByteArrayFromClassName(name);
		return defineClass(name, byteArrayFromClassName, 0, byteArrayFromClassName.length);
	}

	/**
	 * 通过类的全限定名称获取到类的二进制数据
	 *
	 * @param name
	 * @return
	 */
	private byte[] getByteArrayFromClassName(String name) {
		String classPath = convertNameToPath(name);
		byte[] data = null;
		int off = 0;
		int length = 0;
		try (BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(Paths.get(classPath)))) {
			data = new byte[bufferedInputStream.available()];
			while ((length = bufferedInputStream.read(data, off, data.length - off)) > 0) {
				off += length;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return data;
	}

	/**
	 * 通过类的全限定名称获取到对应类文件的的字节码文件路径
	 *
	 * @param name
	 * @return
	 */
	private String convertNameToPath(String name) {
		String relativePath = name.replace(".", File.separator);
		String absolutePath = path + File.separator + relativePath + ".class";
		return absolutePath;
	}
}
