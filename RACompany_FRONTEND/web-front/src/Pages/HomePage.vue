<template>
	<div>
		<div>
			<b-navbar toggleable="lg" type="dark" variant="dark">
				<b-navbar-brand>
					<router-link to="/">Home </router-link>
				</b-navbar-brand>
				<div>
					<b-navbar-brand >
						<router-link to="/user">User: {{ user.firstname }}</router-link>
					</b-navbar-brand>
				</div>

			<b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

			<b-collapse id="nav-collapse" is-nav>

				<!-- Right aligned nav items -->
				<b-navbar-nav class="ml-auto">

					<b-navbar-brand v-if="user === ''">
						<router-link to="/login">Log In</router-link>
					</b-navbar-brand>
					<b-navbar-brand v-if="user === ''">
						<router-link to="/reg">Sign In </router-link>
					</b-navbar-brand>
					<b-navbar-brand v-if="user != ''">
						<b-button variant="primary" @click="LogOut()">
							LogOut 
						</b-button> 
					</b-navbar-brand>
				</b-navbar-nav>
			</b-collapse>
			</b-navbar>
		</div>
		<router-view/>
		<FunctionalCalendar v-model="calendarData" :configs ="calendarConfigs" 
			@choseDay="dayClicked" @selectedDaysCount="daysCount"/>
	</div>
</template>

<script>
import AuthService from '../service/AuthService'
import {FunctionalCalendar} from 'vue-functional-calendar';

import axios from 'axios'

export default {
	name: 'HomePage',
	components : {
		FunctionalCalendar
	},
	data() {
		return{

			user: '',
			msg: '',
			calendarData : {},
			calendarConfigs : {
				sundayStart : false,
				dataFormat : 'dd/mm/yyyy',
				limits : false,
				isDatePicker : true,
				isDateRange : true,
				isMultipleDatePicker : true,
				isMultiple : false,
				withTimePicker : false,
				isDark : true,
				//isModal : true
				
			},
			daysNumber : 0,
			startDate : null,
			endDate : null

		}
	},
	created: function(){
		axios
			.get('http://localhost:8080/RACompany/rest/currentUser')
			.then(res => (this.user = res.data))
			.catch(console.log("currentUser"))
	},
	methods: {
		async LogOut() {
			try{
			const credentials = {
				username: this.user.username,
					password: this.user.password,
					sex: this.user.sex,
					userRole: this.user.userRole,
					firstname: this.user.firstname,
					lastname: this.user.lastname
			}
			await AuthService.logout(credentials);

			this.$router.push('/login');
			this.$router.go();
			}catch (e) {
				this.msg = e.response.data
			}
		},
		dayClicked(value){
			if(this.daysNumber === null){
				this.startDate = value;
				this.startDate.isDateRangeStart = true;
			}
			else{
				this.endDate = value;
				this.endDate.isDateRangeEnd = true;
			}
			console.log(value);

		},
		daysCount(value){
			console.log("number of days "+value);
			this.daysNumber = value;
		}
	}
}
</script>
