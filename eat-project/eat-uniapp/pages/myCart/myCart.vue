<template>
	<view class="container">
		<!-- 新增的黄色顶部区域 -->
		<view class="yellow-header"></view>

		<view class="list">
			<view class="no-cart" v-if="cartData.length<=0">
				购物车空空如也。。。<text @click="toProduct">去购买</text>
			</view>

			<view class="item" v-for="item in cartData">
				<image :src="item.product.pimageurl" mode=""></image>
				<view class="content">
					<view class="title">{{item.product.pname}}</view>
					<view class="text">{{item.product.tintroduce}}</view>
					<view class="price">
						<view>￥{{item.product.tprice}}</view>
						<view class="number">
							<view @click="changeNumber('down',item.id)">-</view>
							<view class="contro">
								{{item.number}}
							</view>
							<view @click="changeNumber('add',item.id)">+</view>
						</view>
					</view>
				</view>
				<view class="delete" @click="delCart(item.id)">
					删除
				</view>
			</view>
		</view>

		<view class="footer">
			<view class="left-footer">
				合计:￥
				<view class="pay-price">
					{{getTotalPrice}}
				</view>
			</view>
			<view class="to-pay" @click="addOrder()">去结算</view>
		</view>
	</view>
</template>

<script>
	import {
		myCart,
		deleteCart,
		changeNumber,
		addOrder
	} from "@/api/index";

	export default {
		data() {
			return {
				cartData: []
			}
		},
		onLoad() {},
		onShow() {
			this.queryCartInfo()
		},
		methods: {
			queryCartInfo() {
				myCart().then(res => {
					console.log(res.data)
					this.cartData = res.data
				})
			},
			delCart(id) {
				deleteCart(id).then(res => {
					this.cartData = res.data
					uni.showToast({
						title: "删除成功"
					})
					this.queryCartInfo()
				})
			},
			changeNumber(cmd, id) {
				changeNumber(id, cmd).then(res => {
					uni.showToast({
						title: "操作成功"
					})
					this.queryCartInfo()
				})
			},
			addOrder() {
				addOrder().then(res => {
					uni.showToast({
						title: "购买成功"
					})
					uni.switchTab({
						url: "/pages/my/my"
					})
				})
			},
			toProduct() {
				uni.switchTab({
					url: "/pages/product/product"
				})
			}
		},
		computed: {
			getTotalPrice() {
				var num = 0;
				for (var i = 0; i < this.cartData.length; i++) {
					var cart = this.cartData[i];
					num += cart.number * cart.product.tprice
				}
				return num.toFixed(2)
			}
		}
	}
</script>

<style scoped>
	/* 新增的黄色顶部区域样式 */
	.yellow-header {
		height: 170rpx;
		width: 100%;
		background-color: #FFF9E6;
		margin-bottom: 20rpx;
		box-shadow: 0 4rpx 10rpx rgba(255, 165, 0, 0.1);
	}

	/* 列表区域 start */
	.no-cart {
		text-align: center;
		margin-top: 200rpx;
		color: #ccc;
	}

	.no-cart text {
		color: orange;
	}

	.item {
		display: flex;
		justify-content: space-around;
		align-items: center;
		margin-bottom: 15rpx;
		border-bottom: 1px solid #ccc;
		padding-bottom: 15rpx;
	}

	.item image {
		width: 150rpx;
		height: 150rpx;
	}

	.delete {
		color: #fff;
		background: orange;
		border-radius: 50%;
		width: 100rpx;
		height: 60rpx;
		font-weight: bold;
		text-align: center;
		line-height: 60rpx;
	}

	.title {
		font-size: 30rpx;
		font-weight: bold;
	}

	.text {
		color: #ccc;
	}

	.price {
		display: flex;
		justify-content: space-between;
	}

	.number {
		display: flex;
	}

	.contro {
		border: 1px solid #000;
		width: 45rpx;
		height: 45rpx;
		text-align: center;
		line-height: 45rpx;
		margin-left: 15rpx;
		margin-right: 15rpx;
	}

	.content {
		width: 300rpx;
	}

	.list {
		padding-bottom: 120px;
	}

	/* 列表区域 end */

	/* 底部区域 :start */
	.footer {
		display: flex;
		width: 100%;
		height: 60px;
		position: fixed;
		bottom: 50px;
		left: 0;
		background: #fff;
		justify-content: space-between;
		align-items: center;
		padding: 0 25rpx;
		box-sizing: border-box;
		border-top: 1px solid #ccc;
	}

	.left-footer {
		display: flex;
		line-height: 60px;
	}

	.to-pay {
		color: #fff;
		background: orange;
		border-radius: 50%;
		width: 140rpx;
		height: 60rpx;
		text-align: center;
		line-height: 60rpx;
	}

	.pay-price {
		font-size: 45rpx;
		color: orange;
		font-weight: bold;
	}

	/* 顶部区域 end */
</style>