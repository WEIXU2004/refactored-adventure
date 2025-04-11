<template>
	<view class="container">

		<view class="swiper">
			<swiper :indicator-dots="true" :autoplay="true" :interval="3000" :duration="1000" class="h100">
				<!-- swiper-item表示每一项 -->
				<swiper-item v-for="item in swiperList">
					<view class="swiper-item">
						<image :src="item.iurl" mode=""></image>
					</view>
				</swiper-item>

			</swiper>

		</view>
		<view class="list">
			<view class="left-list">
				<!-- ==表示的是值相等，但是类型不一定相等 -->
				<!-- ===表示的是值和类型都相等 -->
				<view v-for="(item,i) in typeList" :class="i===index?'current':''" @click="selectTab(i,item.id)">
					<image :src="item.timageurl" mode=""></image>
					<view>{{item.typename}}</view>
				</view>
			</view>
			<view class="right-list">
				<view v-for="item in productList">
					<image class="photo" :src="item.pimageurl" mode=""></image>
					<view style="margin-left: 25rpx;margin-right:25rpx;width:325rpx">

						<view class="title">{{item.pname}}</view>
						<view class="number">{{item.tintroduce}}</view>
						<view style="display: flex;justify-content: space-between;width: 100%;">
							<view>
								￥
								<text class="price">
									16
								</text>起
							</view>
							<image class="cart" src="../../static/cart.png" mode="" @click="addCart(item)"></image>
						</view>
					</view>

				</view>
			</view>

		</view>
	</view>
</template>

<script>
	import {
		queryImageByType,
		getTypes,
		queryProductByType,
		addCart
	} from "@/api/index";

	export default {
		data() {
			return {
				//当前索引值
				index: 0,
				//定义图片数组
				swiperList: [],
				typeList: [],
				productList: []
			}
		},
		onLoad() {
			this.getSwiperImageList()
			//函数调用
			this.getTypeList()

			this.queryProductByType(1)
		},
		methods: {
			// 轮播图获取接口
			getSwiperImageList() {

				queryImageByType(3).then(res => {
					console.log(res.data)
					this.swiperList = res.data
				})


			},

			//分类获取接口
			getTypeList() {

				getTypes().then(res => {
					this.typeList = res.data
				})


			},
			//切换不同的分类
			selectTab(currentIndex, id) {
				this.index = currentIndex
				this.queryProductByType(id)
			},
			//切换
			queryProductByType(productId) {

				queryProductByType(productId).then(res => {
					this.productList = res.data
				})

			},
			addCart(product) {
				console.log("购物车")
				console.log(product)
				// http://47.96.80.123:8000/cart/addCart?pid=3&number=1&token=63e3423e4185eeb0d9f19d32479bd785&tprice=20

				addCart(product.id + "&tprice=" + product.tprice).then(res => {
					console.log(res)
					if (res.code === 200) {
						uni.showToast({
							title: "添加成功",
							duration: 2000,
						})
					} else {
						uni.showToast({
							title: res.data.msg,
							duration: 2000,
							icon: "error"
						})
					}
				})
			}


		}
	}
</script>

<style>
	/* 顶部区域 start */
	.top {
		height: 10%;
		/* ctrl+/ 注释 取消注释 */
		/* background: skyblue; */
		/* 弹性盒模型布局 */
		display: flex;
		/* 设置主轴的对齐方式 x*/
		justify-content: space-between;
		padding: 15rpx;
		/* 元素的总高度和宽度包含内边距和边框(padding 与 border) : */
		box-sizing: border-box;
		/* 交叉轴 y */
		align-items: center;
	}

	.top image {
		width: 160rpx;
		height: 100rpx;
	}

	.swiper {
		height: 500rpx;
		/* background: pink; */
	}

	.list {
		margin-top: 25rpx;
		height: 60%;
		/* background: #ccc; */
	}

	.tea {
		font-weight: bold;
		color: orange;
		font-size: 42rpx;

	}

	.content {
		color: #ccc;
		font-size: 25rpx;
	}

	/* 顶部区域 end */

	/* 轮播区域 start */
	/* 设置轮播图片的大小 */
	.h100 {
		height: 100%;
	}

	.swiper-item image {
		width: 100%;
		height: 100%;
	}

	.swiper-item {
		height: 100%;
	}

	/* 轮播区域 end */


	/* 底部列表区域 start */
	.list {

		/* 弹性盒模型 */
		display: flex;

		/* 主轴 */
		justify-content: space-between;
	}

	.list .left-list {
		/* 750rpx */
		height: 100%;
		width: 150rpx;
	}

	.left-list image {
		width: 70rpx;
		height: 70rpx;
	}

	.left-list>view {
		height: 150rpx;
		background: #f5f5f5;
		padding: 10rpx;
		box-sizing: border-box;
	}

	.left-list view {
		text-align: center;
		font-weight: bold;
		font-size: 26rpx;
	}

	.list .right-list {
		width: 575rpx;
		height: 100%;
		/* background: pink; */

		overflow: auto;
	}

	.current {
		background: #fff !important;
		color: orange;
	}

	/* 底部列表区域 end */
</style>
<style>
	.right-list>view {
		display: flex;
		align-items: center;
		margin-bottom: 25rpx;
	}

	.photo {
		width: 200rpx;
		height: 200rpx;
	}

	.cart {
		width: 50rpx;
		height: 50rpx;
	}

	.title {
		font-size: 35rpx;
		font-weight: bold;
	}

	.number {
		font-size: 25rpx;
		color: #ccc;
		line-height: 60rpx;
	}

	.price {
		font-size: 25rpx;
		color: orange;
		display: inline-block;
		font-weight: bold;
	}
</style>