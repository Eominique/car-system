package com.validation

import com.exception.JsonConversionException
import com.google.gson.GsonBuilder
import java.io.FileReader
import java.io.FileWriter
import java.lang.reflect.ParameterizedType
import java.util.*


abstract class JsonConverter<T>(private val jsonFileName: String) {


    private val gson = GsonBuilder()
            .setPrettyPrinting()
            .create()
    private val type = (javaClass
            .getGenericSuperclass() as ParameterizedType)
            .actualTypeArguments[0]


    

    //conversion from object to json
    fun toJson(element: T?): Unit {
        try {
            FileWriter(jsonFileName).use { fileWriter ->
                {
                    if (element == null) {
                        throw NullPointerException("ELEMENT IS NULL")
                    }
                    gson.toJson(element, fileWriter)
                }
            }
        } catch (e: Exception) {
            throw JsonConversionException(e.message)
        }
    }

    //conversion from json to object
    fun fromJson(): Optional<T> {
        try {
    FileReader(jsonFileName).use {
        fileReader ->
        return Optional.of(gson.fromJson(fileReader, type))

        }}catch (e: Exception){
            throw JsonConversionException(e.message)
        }
    }

}




