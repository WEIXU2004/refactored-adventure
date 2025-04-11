<template>
	<view class="container">
		<view class="yellow-header"></view>
		<view class="header">
			<view class="user-info">
				<text class="username">用户名：{{userData.username}}</text>
				<button class="logout-btn" @click="logout">退出登录</button>
			</view>
		</view>

		<view class="order-tabs">
			<view v-for="(item,i) in navData" :key="i" :class="['tab-item', currentIndex===i ? 'active' : '']"
				@click="changeIndex(i)">
				{{item}}
			</view>
		</view>

		<view class="order-list">
			<view class="order-item" v-for="(item, index) in orderData" :key="index">
				<image class="product-image" :src="item.product[0].pimageurl" mode="aspectFill"></image>
				<view class="order-info">
					<text class="order-time">下单时间: {{item.otime}}</text>
					<text class="order-price">订单总额: ￥{{item.oprice}}</text>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	import {
		queryOrder,
		queryUserInfo
	} from "@/api/index";

	export default {
		data() {
			return {
				navData: ["全部订单", "已收货", "未收货", "退订"],
				currentIndex: 0,
				teaToken: "",
				userData: {},
				orderData: []
			}
		},
		onShow() {
			this.queryUserInfo()
			this.queryOrder()
		},
		methods: {
			changeIndex(index) {
				this.currentIndex = index
				var ostate = ""
				if (index === 0) {
					ostate = ""
				} else if (index === 1) {
					ostate = "1"
				} else if (index === 3) {
					ostate = "2"
				} else if (index == 2) {
					ostate = "0"
				}

				queryOrder(ostate).then(res => {
					this.orderData = res.data
				})
			},
			queryUserInfo() {
				queryUserInfo().then(res => {
					this.userData = res.data
				})
			},
			queryOrder() {
				queryOrder("").then(res => {
					this.orderData = res.data
				})
			},
			logout() {
				uni.showModal({
					title: '提示',
					content: '你确定退出登录吗',
					success: function(res) {
						if (res.confirm) {
							uni.removeStorage({
								key: 'token',
								success: function() {
									console.log('用户 token 已删除');
								},
								fail: function(err) {
									console.error('删除用户 token 失败', err);
								}
							});
							uni.showToast({
								title: '用户已退出',
								duration: 2000
							});
							setTimeout(() => {
								uni.navigateTo({
									url: "/pages/welcome/welcome"
								})
							}, 2000)
						} else if (res.cancel) {
							uni.showToast({
								title: '用户取消退出',
								duration: 2000
							});
						}
					}
				});
			}
		}
	}
</script>

<style scoped>
	.container {
		background-color: white;
		min-height: 100vh;
	}

	.yellow-header {
		height: 170rpx;
		width: 100%;
		background-color: #FFF9E6;
		margin-bottom: 20rpx;
		box-shadow: 0 4rpx 10rpx rgba(255, 165, 0, 0.1);
	}

	.header {
		background-color: white;
		padding: 30rpx;
		box-shadow: 0 2rpx 10rpx rgba(255, 165, 0, 0.1);
	}

	.user-info {
		display: flex;
		justify-content: space-between;
		align-items: center;
	}

	.username {
		font-size: 40rpx;
		color: #FF7B54;
		font-weight: bold;
	}

	.logout-btn {
		background-color: #FF7B54;
		color: white;
		border-radius: 20rpx;
		padding: 15rpx 40rpx;
		font-size: 33rpx;
		border: none;
	}

	.order-tabs {
		display: flex;
		flex-direction: column;
		margin: 20rpx 30rpx;
		background-color: white;
		border-radius: 16rpx;
		overflow: hidden;
		box-shadow: 0 4rpx 12rpx rgba(255, 165, 0, 0.1);
	}

	.tab-item {
		padding: 28rpx 30rpx;
		font-size: 30rpx;
		color: #666;
		border-bottom: 1rpx solid #FFE8D6;
	}

	.tab-item:last-child {
		border-bottom: none;
	}

	.tab-item.active {
		color: #FF7B54;
		font-weight: bold;
		background-color: #FFF4EC;
	}

	.order-list {
		margin: 20rpx 30rpx;
	}

	.order-item {
		display: flex;
		padding: 30rpx;
		background-color: white;
		border-radius: 16rpx;
		margin-bottom: 20rpx;
		box-shadow: 0 4rpx 12rpx rgba(255, 165, 0, 0.1);
	}

	.product-image {
		width: 180rpx;
		height: 180rpx;
		border-radius: 12rpx;
		margin-right: 30rpx;
	}

	.order-info {
		flex: 1;
		display: flex;
		flex-direction: column;
		justify-content: space-between;
	}

	.order-time {
		font-size: 28rpx;
		color: #666;
	}

	.order-price {
		font-size: 32rpx;
		color: #FF7B54;
		font-weight: bold;
	}
</style>