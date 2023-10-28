package com.thiago.ecommerceappmvvm.domain.util

import android.util.Log
import com.thiago.ecommerceappmvvm.domain.models.ErrorResponse
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

object ResponseToRequest {

    fun <T>send(result: Response<T>):Resource<T>{
        return  try {
            if(result.isSuccessful){
                Resource.Success(result.body()!!)
            }else{
                val errorResponse : ErrorResponse? = ConvertErrorBody.convert(result.errorBody())
                Resource.Failure(errorResponse?.message ?: "Error desconhecido")
            }


        }
        catch (e: HttpException){
            Log.d("AuthRepositoryImpl", "Error: $e")
            e.printStackTrace()
            Resource.Failure(e.message ?: "Erro desconhecido na declaração Http")
        }
        catch (e: IOException){
            Log.d("AuthRepositoryImpl", "Error: $e")
            e.printStackTrace()
            Resource.Failure("Verifica a conexão com a internet")
        }

        catch (e:Exception){
            Log.d("AuthRepositoryImpl", "Error: $e")
            e.printStackTrace()
            Resource.Failure(e.message ?: "Erro desconhecido")
        }
    }
}