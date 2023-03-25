/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.core.type;

import org.springframework.lang.Nullable;

/**
 * Interface that defines abstract metadata of a specific class,
 * in a form that does not require that class to be loaded yet.
 *
 * @author Juergen Hoeller
 * @since 2.5
 * @see StandardClassMetadata
 * @see org.springframework.core.type.classreading.MetadataReader#getClassMetadata()
 * @see AnnotationMetadata
 */
public interface ClassMetadata {

	/**
	 * 返回基础类的名称。
	 * Return the name of the underlying class.
	 */
	String getClassName();

	/**
	 * 返回底层类是否表示一个接口
	 * Return whether the underlying class represents an interface.
	 */
	boolean isInterface();

	/**
	 * 返回底层类是否表示注释。
	 * Return whether the underlying class represents an annotation.
	 * @since 4.1
	 */
	boolean isAnnotation();

	/**
	 * 是否抽象类
	 * Return whether the underlying class is marked as abstract.
	 */
	boolean isAbstract();

	/**
	 * 返回底层类是否表示具体类，即既不是接口也不是抽象类。
	 * Return whether the underlying class represents a concrete class,
	 * i.e. neither an interface nor an abstract class.
	 */
	default boolean isConcrete() {
		return !(isInterface() || isAbstract());
	}

	/**
	 * 是否final修饰
	 * Return whether the underlying class is marked as 'final'.
	 */
	boolean isFinal();

	/**
	 * 判断底层类是否独立，即是顶层类还是可以独立于外围类构造的嵌套类（静态内部类）。
	 * Determine whether the underlying class is independent, i.e. whether
	 * it is a top-level class or a nested class (static inner class) that
	 * can be constructed independently of an enclosing class.
	 */
	boolean isIndependent();

	/**
	 * 返回底层类是否在封闭类中声明（即底层类是内部嵌套类还是方法中的局部类）。如果此方法返回 false，则底层类是顶级类。
	 * Return whether the underlying class is declared within an enclosing
	 * class (i.e. the underlying class is an inner/nested class or a
	 * local class within a method).
	 * <p>If this method returns {@code false}, then the underlying
	 * class is a top-level class.
	 */
	default boolean hasEnclosingClass() {
		return (getEnclosingClassName() != null);
	}

	/**
	 * 返回底层类的封闭类的名称，如果底层类是顶级类，则返回 null。
	 * Return the name of the enclosing class of the underlying class,
	 * or {@code null} if the underlying class is a top-level class.
	 */
	@Nullable
	String getEnclosingClassName();

	/**
	 * 是否有父类
	 * Return whether the underlying class has a superclass.
	 */
	default boolean hasSuperClass() {
		return (getSuperClassName() != null);
	}

	/**
	 * 获取父类名
	 * Return the name of the superclass of the underlying class,
	 * or {@code null} if there is no superclass defined.
	 */
	@Nullable
	String getSuperClassName();

	/**
	 * 获取接口列表
	 * Return the names of all interfaces that the underlying class
	 * implements, or an empty array if there are none.
	 */
	String[] getInterfaceNames();

	/**
	 * 返回声明为此 ClassMetadata 对象表示的类的成员的所有类的名称。
	 * 这包括公共类、受保护类、默认（包）访问以及类声明的私有类和接口，
	 * 但不包括继承的类和接口。如果不存在成员类或接口，则返回一个空数组。
	 * Return the names of all classes declared as members of the class represented by
	 * this ClassMetadata object. This includes public, protected, default (package)
	 * access, and private classes and interfaces declared by the class, but excludes
	 * inherited classes and interfaces. An empty array is returned if no member classes
	 * or interfaces exist.
	 * @since 3.1
	 */
	String[] getMemberClassNames();

}
