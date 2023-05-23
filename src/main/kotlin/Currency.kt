import com.google.gson.annotations.SerializedName

data class Currency(
    val id: Int,
    val code: Int,
    @SerializedName("Ccy")
    val ccy: String,
    @SerializedName("CcyNm_RU")
    val ccyNameRU: String,
    @SerializedName("CcyNm_UZ")
    val ccyNameUZ: String,
    @SerializedName("CcyNm_UZC")
    val ccyNameUZC: String,
    @SerializedName("CcyNm_EN")
    val ccyNameEN: String,
    @SerializedName("Nominal")
    val nominal: Int,
    @SerializedName("Rate")
    val rate: String,
    @SerializedName("Diff")
    val diff:String,
    @SerializedName("Date")
    val date: String,
){
    override fun toString(): String {
        return "Currency:$ccy \nRate:$rate \nDate:$date\n"
    }
}