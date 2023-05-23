import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T> Gson.getFromJson(json: String): T = fromJson(json, object: TypeToken<T>() {}.type)

fun main() {

    val baseURL = "https://cbu.uz/ru/arkhiv-kursov-valyut/json/"
    val url = URL(baseURL)

    val urlConnection = url.openConnection()
    val inputStream = urlConnection.getInputStream()

    val responseReader = InputStreamReader(inputStream)
    val bufferedReader = BufferedReader(responseReader)

    var response = bufferedReader.readLine()
    val builder = StringBuilder()

    try {
        while (response != null){
            builder.append(response)
            response = bufferedReader.readLine()
        }
        inputStream.close()

        val gson = Gson()
        val currencyList:List<Currency> = gson.getFromJson(builder.toString() )

        for (currency: Currency in currencyList){
            println(currency.toString() )
        }

    } catch (e:IOException){
        println("Error")
    }

}