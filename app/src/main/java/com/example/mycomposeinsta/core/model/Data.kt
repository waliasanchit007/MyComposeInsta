package com.example.mycomposeinsta.core.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("account_id")
    val accountId: Int?,
    @SerializedName("account_url")
    val accountUrl: String?,
    @SerializedName("ad_config")
    val adConfig: AdConfig?,
    @SerializedName("ad_type")
    val adType: Int?,
    @SerializedName("ad_url")
    val adUrl: String?,
    @SerializedName("animated")
    val animated: Boolean?,
    @SerializedName("bandwidth")
    val bandwidth: Long?,
    @SerializedName("comment_count")
    val commentCount: Int?,
    @SerializedName("cover")
    val cover: String?,
    @SerializedName("cover_height")
    val coverHeight: Int?,
    @SerializedName("cover_width")
    val coverWidth: Int?,
    @SerializedName("datetime")
    val datetime: Long?,
    @SerializedName("description")
    val description: Any?,
    @SerializedName("downs")
    val downs: Int?,
    @SerializedName("edited")
    val edited: Int?,
    @SerializedName("favorite")
    val favorite: Boolean?,
    @SerializedName("favorite_count")
    val favoriteCount: Int?,
    @SerializedName("gifv")
    val gifv: String?,
    @SerializedName("has_sound")
    val hasSound: Boolean?,
    @SerializedName("height")
    val height: Int?,
    @SerializedName("hls")
    val hls: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("images")
    val images: List<Image>?,
    @SerializedName("images_count")
    val imagesCount: Int?,
    @SerializedName("in_gallery")
    val inGallery: Boolean?,
    @SerializedName("in_most_viral")
    val inMostViral: Boolean?,
    @SerializedName("include_album_ads")
    val includeAlbumAds: Boolean?,
    @SerializedName("is_ad")
    val isAd: Boolean?,
    @SerializedName("is_album")
    val isAlbum: Boolean?,
    @SerializedName("layout")
    val layout: String?,
    @SerializedName("link")
    val link: String?,
    @SerializedName("mp4")
    val mp4: String?,
    @SerializedName("mp4_size")
    val mp4Size: Int?,
    @SerializedName("nsfw")
    val nsfw: Boolean?,
    @SerializedName("points")
    val points: Int?,
    @SerializedName("privacy")
    val privacy: String?,
    @SerializedName("processing")
    val processing: ProcessingX?,
    @SerializedName("score")
    val score: Int?,
    @SerializedName("section")
    val section: String?,
    @SerializedName("size")
    val size: Int?,
    @SerializedName("tags")
    val tags: List<Tag>?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("topic")
    val topic: Any?,
    @SerializedName("topic_id")
    val topicId: Any?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("ups")
    val ups: Int?,
    @SerializedName("views")
    val views: Int?,
    @SerializedName("vote")
    val vote: Any?,
    @SerializedName("width")
    val width: Int?
)