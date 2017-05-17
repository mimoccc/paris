package com.airbnb.paris.processor

import com.airbnb.paris.annotations.Styleable
import com.squareup.javapoet.ClassName

import javax.lang.model.element.Element
import javax.lang.model.element.TypeElement
import javax.lang.model.type.TypeMirror

internal class StyleableClassInfo private constructor(val packageName: String, val name: String, val type: TypeMirror, val resourceName: String) {

    companion object {

        fun fromElement(element: Element): StyleableClassInfo {
            val packageName = ClassName.get(element as TypeElement).packageName()
            val name = element.getSimpleName().toString()
            val type = element.asType()
            val styleable = element.getAnnotation(Styleable::class.java)
            val resourceName = styleable.value

            return StyleableClassInfo(packageName, name, type, resourceName)
        }
    }
}