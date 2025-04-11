<template>
	<view class="container">
		<swiper :indicator-dots="true" :autoplay="true" :interval="3000" :duration="1000"
			indicator-active-color="#FF7F47" style="height: 300px;">
			<swiper-item v-for="item in swiperImageList">
				<view class="swiper-item">
					<image :src="item.iurl" mode="aspectFill"></image>
				</view>
			</swiper-item>
		</swiper>

		<view class="box" @click="toProduct">
			<view>
				<image src="../../static/mendian.png"></image>
				<view class="title">门店自取</view>
				<view class="content">点单无需排队</view>
			</view>
			<view>
				<image src="../../static/waimai.png"></image>
				<view class="title">外卖</view>
				<view class="content">配送到家</view>
			</view>
		</view>

		<!-- 替换为单张宣传图 -->
		<view class="promo-image">
			<image src="../../static/eat.png" mode="widthFix" style="height: 400rpx;"></image>
		</view>
	</view>
</template>

<script>
	import {
		queryImageByType
	} from "@/api/index";

	export default {
		data() {
			return {
				title: 'Hello',
				swiperImageList: [{
					iurl: ""
				}]
			}
		},
		onLoad() {},
		onShow() {
			this.getBannerList()
		},
		methods: {
			getCarouselList() {
				getCarouselQueryPage({}).then(res => {
					this.carouselList = res.data.list
				})
			},
			toUrl() {
				uni.navigateTo({
					url: ""
				})
			},
			getBannerList() {
				queryImageByType(2).then(res => {
					console.log(res.data)
					this.swiperImageList = res.data
				})
			},
			toProduct() {
				uni.switchTab({
					url: "/pages/product/product"
				})
			}
		}
	}
</script>

<style scoped>
	.swiper-item {
		height: 100%;
	}

	.swiper-item image {
		width: 100%;
		height: 100%;
	}

	.container {
		background-color: #ffffff;
		min-height: 100vh;
	}

	.box {
		display: flex;
		justify-content: space-around;
		margin: 30px 10px;
		background-color: #fff;
		border-radius: 20px;
		padding-top: 20px;
		padding-bottom: 20px;
		box-shadow: 0 2px 12px rgba(0, 0, 0, 0.05);
	}

	.box image {
		width: 100px;
		height: 100px;
	}

	.box>view view {
		text-align: center;
	}

	.title {
		font-weight: bold;
		font-size: 23px;
		margin-bottom: 5px;
		color: #333;
	}

	.content {
		color: #999;
	}

	/* 调整后的宣传图样式 */
	.promo-image {
		margin: 10px 10px 30px 10px;
		border-radius: 12px;
		overflow: hidden;
		box-shadow: 0 2px 12px rgba(0, 0, 0, 0.05);
		height: 380rpx;
		/* 设置固定高度 */
	}

	.promo-image image {
		width: 100%;
		height: 100%;
		object-fit: cover;
		/* 保持图片比例并填充容器 */
	}
</style>