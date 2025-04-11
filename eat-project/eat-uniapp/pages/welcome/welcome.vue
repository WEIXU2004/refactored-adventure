<template>
	<view>
		<view class="container">
			<view class="swiper">
				<swiper indicator-active-color="#ff9966" style="height:800rpx" :indicator-dots="true" :autoplay="true"
					:interval="3000" :duration="1000">
					<swiper-item v-for="item in swiperList" :key="item.id">
						<view class="swiper-item">
							<image :src="item.iurl" mode=""></image>
						</view>
					</swiper-item>
				</swiper>
			</view>
			<view class="content">
				<view>欢迎来到</view>
				<view>味觉工坊</view>
				<view>随时点单 · 即刻享受</view>
			</view>
			<view class="btn">
				<button @click="toLoginPage">登录</button>
				<button @click="toRegisterPage">注册</button>
			</view>
		</view>
	</view>
</template>

<script>
	import {
		queryImageByType
	} from "@/api/index"
	export default {
		data() {
			return {
				swiperList: []
			}
		},
		onShow() {
			this.getSwiperList()
		},
		methods: {
			getSwiperList() {
				queryImageByType(1).then(res => {
					this.swiperList = res.data
				})
			},
			toLoginPage() {
				uni.navigateTo({
					url: "/pages/login/login"
				})
			},
			toRegisterPage() {
				uni.navigateTo({
					url: "/pages/register/register"
				})
			}
		}
	}
</script>

<style scoped>
	.container {
		display: flex;
		flex-direction: column;
		align-items: center;
		background-image: linear-gradient(120deg, #ffecd2 0%, #fcb69f 100%);
		min-height: 100vh;
		padding-bottom: 60rpx;
	}

	.swiper {
		width: 100%;
		margin-bottom: 40rpx;
	}

	.swiper-item {
		height: 100%;
	}

	.swiper-item image {
		width: 100%;
		height: 100%;
		object-fit: cover;
	}

	.content {
		padding: 30rpx;
		box-sizing: border-box;
		text-align: center;
		margin-bottom: 60rpx;
	}

	.content view:nth-child(1) {
		font-size: 60rpx;
		color: #ff7e5f;
		margin-bottom: 10rpx;
		font-weight: 500;
		letter-spacing: 2rpx;
	}

	.content view:nth-child(2) {
		color: #ff5e62;
		font-size: 72rpx;
		font-weight: 600;
		margin: 30rpx 0;
		text-shadow: 2rpx 2rpx 4rpx rgba(0, 0, 0, 0.1);
		letter-spacing: 4rpx;
	}

	.content view:nth-child(3) {
		font-size: 60rpx;
		color: #ff8a65;
		letter-spacing: 3rpx;
		font-weight: 500;
	}

	.btn {
		width: 100%;
		display: flex;
		flex-direction: column;
		align-items: center;
	}

	.btn button {
		width: 80%;
		font-weight: bold;
		border-radius: 50rpx;
		height: 90rpx;
		line-height: 90rpx;
		font-size: 40rpx;
		box-shadow: 0 4rpx 12rpx rgba(0, 0, 0, 0.1);
		transition: all 0.3s;
	}

	.btn button:nth-child(1) {
		background: linear-gradient(135deg, #409EFF, #64b0ff);
		color: #fff;
	}

	.btn button:nth-child(2) {
		margin-top: 40rpx;
		background: linear-gradient(135deg, #67C23A, #85ce61);
		color: #fff;
	}

	.btn button:active {
		transform: translateY(4rpx);
		box-shadow: 0 2rpx 6rpx rgba(0, 0, 0, 0.1);
	}
</style>