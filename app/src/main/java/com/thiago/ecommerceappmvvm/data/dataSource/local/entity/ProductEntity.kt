package com.thiago.ecommerceappmvvm.data.dataSource.local.entity
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey var id: String = "",
    @ColumnInfo("name") var name: String = "",
    @ColumnInfo("description") var description: String = "",
    @ColumnInfo("id_category") var idCategory: String = "",
    @ColumnInfo("image1") var image1: String = "",
    @ColumnInfo("image2") var image2: String = "",
    @ColumnInfo("price") var price: Double = 0.0,
)
