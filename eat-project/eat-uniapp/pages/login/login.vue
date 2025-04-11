<template>
	<view class="container">
		<view class="login-box">
			<view class="title">
				味觉工坊
			</view>

			<input type="text" v-model="userInfo.username" placeholder="请输入用户名称" class="input-field">
			<input type="password" v-model="userInfo.password" placeholder="请输入密码" class="input-field">

			<button class="btn login-btn" @click="userLogin">立即登录</button>
			<button class="btn register-btn" @click="toRegisterPage">跳转注册</button>
			<button class="btn back-btn" @click="toBack">返回</button>
		</view>
	</view>
</template>

<script>
	import {
		login
	} from "@/api/index";
	export default {
		data() {
			return {
				userInfo: {
					username: "",
					password: ""
				}
			}
		},
		methods: {
			toRegisterPage() {
				uni.navigateTo({
					url: "/pages/register/register"
				})
			},
			userLogin() {
				login(this.userInfo).then(res => {
					console.log(res.data)
					uni.showToast({
						title: res.msg,
						duration: 2000,
					});

					setTimeout(() => {
						uni.setStorage({
							key: "token",
							data: res.data.token,
							success: function() {
								console.log('success');
								uni.switchTab({
									url: "/pages/index/index"
								})
							}
						})
					}, 2000)
				})
			},
			toBack() {
				uni.navigateBack()
			}
		}
	}
</script>

<style scoped>
	.container {
		display: flex;
		justify-content: center;
		align-items: center;
		min-height: 100vh;
		background-image: linear-gradient(120deg, #ffecd2 0%, #fcb69f 100%);
	}

	.login-box {
		width: 85%;
		max-width: 700px;
		padding: 80rpx 50rpx;
		background-color: #fff;
		border-radius: 20px;
		box-shadow: 0 10px 30px rgba(255, 140, 105, 0.1);
		display: flex;
		flex-direction: column;
		align-items: center;
		min-height: 800rpx;
	}

	.title {
		font-size: 72rpx;
		font-weight: bold;
		color: #ff7b54;
		margin-bottom: 60rpx;
		text-align: center;
		margin-top: 40rpx;
	}

	.input-field {
		width: 100%;
		height: 60px;
		padding: 0 20px;
		margin-bottom: 25px;
		border: 1px solid #ffd8c9;
		border-radius: 30px;
		font-size: 18px;
		background-color: #fffaf5;
		box-sizing: border-box;
		transition: all 0.3s;
	}

	.input-field:focus {
		border-color: #ff9a76;
		outline: none;
		box-shadow: 0 0 0 2px rgba(255, 123, 84, 0.2);
	}

	.btn {
		width: 100%;
		height: 55px;
		border-radius: 30px;
		font-size: 18px;
		font-weight: bold;
		margin-top: 20px;
		transition: all 0.3s;
		display: flex;
		justify-content: center;
		align-items: center;
	}

	.login-btn {
		background: linear-gradient(135deg, #ff7b54, #ff9a76);
		color: white;
	}

	.register-btn {
		background-image: linear-gradient(-225deg, #FFE29F 0%, #FFA99F 48%, #FF719A 100%);
		color: white;
	}

	.back-btn {
		color: #ff7b54;
		border: 1px solid #ff7b54;
	}

	.btn:active {
		transform: scale(0.98);
	}
</style>