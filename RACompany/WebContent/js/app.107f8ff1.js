(function(t){function e(e){for(var a,s,i=e[0],l=e[1],u=e[2],c=0,p=[];c<i.length;c++)s=i[c],Object.prototype.hasOwnProperty.call(n,s)&&n[s]&&p.push(n[s][0]),n[s]=0;for(a in l)Object.prototype.hasOwnProperty.call(l,a)&&(t[a]=l[a]);m&&m(e);while(p.length)p.shift()();return o.push.apply(o,u||[]),r()}function r(){for(var t,e=0;e<o.length;e++){for(var r=o[e],a=!0,i=1;i<r.length;i++){var l=r[i];0!==n[l]&&(a=!1)}a&&(o.splice(e--,1),t=s(s.s=r[0]))}return t}var a={},n={app:0},o=[];function s(e){if(a[e])return a[e].exports;var r=a[e]={i:e,l:!1,exports:{}};return t[e].call(r.exports,r,r.exports,s),r.l=!0,r.exports}s.m=t,s.c=a,s.d=function(t,e,r){s.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:r})},s.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},s.t=function(t,e){if(1&e&&(t=s(t)),8&e)return t;if(4&e&&"object"===typeof t&&t&&t.__esModule)return t;var r=Object.create(null);if(s.r(r),Object.defineProperty(r,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var a in t)s.d(r,a,function(e){return t[e]}.bind(null,a));return r},s.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return s.d(e,"a",e),e},s.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},s.p="/RACompany/";var i=window["webpackJsonp"]=window["webpackJsonp"]||[],l=i.push.bind(i);i.push=e,i=i.slice();for(var u=0;u<i.length;u++)e(i[u]);var m=l;o.push([0,"chunk-vendors"]),r()})({0:function(t,e,r){t.exports=r("56d7")},"177c":function(t,e,r){},"240f":function(t,e,r){"use strict";var a=r("9902"),n=r.n(a);n.a},"56d7":function(t,e,r){"use strict";r.r(e);r("e260"),r("e6cf"),r("cca6"),r("a79d");var a=r("2b0e"),n=r("1dce"),o=r.n(n),s=r("479b"),i=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{attrs:{id:"app"}},[r("HomePage")],1)},l=[],u=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",[r("div",[r("b-navbar",{attrs:{toggleable:"lg",type:"dark",variant:"dark"}},[r("b-navbar-brand",[r("router-link",{attrs:{to:"/"}},[t._v("Home ")])],1),r("div",[r("b-navbar-brand",[r("router-link",{attrs:{to:"/user"}},[t._v("User: "+t._s(t.user.firstname))])],1)],1),r("b-navbar-toggle",{attrs:{target:"nav-collapse"}}),r("b-collapse",{attrs:{id:"nav-collapse","is-nav":""}},[r("b-navbar-nav",{staticClass:"ml-auto"},[""===t.user?r("b-navbar-brand",[r("router-link",{attrs:{to:"/login"}},[t._v("Log In")])],1):t._e(),""===t.user?r("b-navbar-brand",[r("router-link",{attrs:{to:"/reg"}},[t._v("Sign In ")])],1):t._e(),""!=t.user?r("b-navbar-brand",[r("b-button",{attrs:{variant:"primary"},on:{click:function(e){return t.LogOut()}}},[t._v(" LogOut ")])],1):t._e()],1)],1)],1)],1),r("router-view"),r("FunctionalCalendar",{attrs:{configs:t.calendarConfigs},on:{choseDay:t.dayClicked,selectedDaysCount:t.daysCount},model:{value:t.calendarData,callback:function(e){t.calendarData=e},expression:"calendarData"}})],1)},m=[],c=(r("96cf"),r("1da1")),p=r("bc3a"),d=r.n(p),b="http://localhost:8080/RACompany/rest/",f={login:function(t){return d.a.post(b+"login",t).then((function(t){return t.data}))},signUp:function(t){return d.a.post(b+"register",t).then((function(t){return t.data}))},logout:function(t){return d.a.post(b+"logout",t)}},g={name:"HomePage",components:{FunctionalCalendar:s["a"]},data:function(){return{user:"",msg:"",calendarData:{},calendarConfigs:{sundayStart:!1,dataFormat:"dd/mm/yyyy",limits:!1,isDatePicker:!0,isDateRange:!0,isMultipleDatePicker:!0,isMultiple:!1,withTimePicker:!1,isDark:!0},daysNumber:0,startDate:null,endDate:null}},created:function(){var t=this;d.a.get("http://localhost:8080/RACompany/rest/currentUser").then((function(e){return t.user=e.data})).catch(console.log("currentUser"))},methods:{LogOut:function(){var t=this;return Object(c["a"])(regeneratorRuntime.mark((function e(){var r;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.prev=0,r={username:t.user.username,password:t.user.password,sex:t.user.sex,userRole:t.user.userRole,firstname:t.user.firstname,lastname:t.user.lastname},e.next=4,f.logout(r);case 4:t.$router.push("/login"),t.$router.go(),e.next=11;break;case 8:e.prev=8,e.t0=e["catch"](0),t.msg=e.t0.response.data;case 11:case"end":return e.stop()}}),e,null,[[0,8]])})))()},dayClicked:function(t){null===this.daysNumber?(this.startDate=t,this.startDate.isDateRangeStart=!0):(this.endDate=t,this.endDate.isDateRangeEnd=!0),console.log(t)},daysCount:function(t){console.log("number of days "+t),this.daysNumber=t}}},h=g,v=r("2877"),y=Object(v["a"])(h,u,m,!1,null,null,null),A=y.exports,x={name:"App",components:{HomePage:A}},k=x,_=Object(v["a"])(k,i,l,!1,null,null,null),C=_.exports,w=r("8c4f"),N=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{staticClass:"position"},[r("b-form",[r("b-form-group",{attrs:{id:"input-group-1",label:"Password:","label-for":"input-1"}},[r("b-form-input",{attrs:{id:"input-1",type:"password",required:"",placeholder:"Enter password"},model:{value:t.form.password,callback:function(e){t.$set(t.form,"password",e)},expression:"form.password"}})],1),r("b-form-group",{attrs:{id:"input-group-2",label:"Username:","label-for":"input-2"}},[r("b-form-input",{attrs:{id:"input-2",state:t.validateState("name"),"aria-describedby":"input-1-live-feedback",placeholder:"Enter username"},model:{value:t.$v.form.name.$model,callback:function(e){t.$set(t.$v.form.name,"$model",e)},expression:"$v.form.name.$model"}}),r("b-form-invalid-feedback",{attrs:{id:"input-1-live-feedback"}},[t._v(" This is a requrired field and must be at least 3 characters ")])],1),r("b-button",{on:{click:function(e){return t.login()}}},[t._v(" LogIn ")])],1)],1)},$=[],R=(r("b0c0"),r("b5ae")),O={mixins:[n["validationMixin"]],data:function(){return{form:{password:"",name:""},msg:""}},validations:{form:{password:{required:R["required"],minLength:Object(R["minLength"])(4)},name:{required:R["required"],minLength:Object(R["minLength"])(3)}}},methods:{validateState:function(t){var e=this.$v.form[t],r=e.$dirty,a=e.$error;return r?!a:null},login:function(){var t=this;return Object(c["a"])(regeneratorRuntime.mark((function e(){var r;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.prev=0,r={username:t.form.name,password:t.form.password},e.next=4,f.login(r);case 4:if(t.$v.form.$touch(),!t.$v.form.$anyError){e.next=7;break}return e.abrupt("return");case 7:t.$router.push("/"),t.$router.go(),e.next=14;break;case 11:e.prev=11,e.t0=e["catch"](0),t.msg=e.t0.response.data;case 14:case"end":return e.stop()}}),e,null,[[0,11]])})))()}}},E=O,L=(r("a911"),Object(v["a"])(E,N,$,!1,null,"ee0e0b12",null)),j=L.exports,S=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",[r("div",{staticClass:"searchBox"},[r("b-container",{staticClass:"bv-example-row"},[r("b-row",[r("b-col",[r("b-form-group",{attrs:{"label-cols":"4","label-cols-lg":"3",label:"Location","label-for":"location"}},[r("b-form-input",{attrs:{id:"location",placeholder:"Input city"},model:{value:t.location,callback:function(e){t.location=e},expression:"location"}})],1)],1),r("b-col",[r("b-form-group",{attrs:{"label-cols":"4","label-cols-lg":"6",label:"Number of guests","label-for":"number-of-guest"}},[r("b-form-input",{attrs:{id:"number-of-guest",placeholder:"Input number"},model:{value:t.guestNumber,callback:function(e){t.guestNumber=e},expression:"guestNumber"}})],1)],1),r("b-col",[r("b-form-group",{attrs:{"label-cols":"4","label-cols-lg":"4",label:"Starting date","label-for":"datepicker"}},[r("b-form-datepicker",{staticClass:"mb-2",attrs:{id:"datepicker"},model:{value:t.starting_date,callback:function(e){t.starting_date=e},expression:"starting_date"}})],1)],1)],1),r("b-row",[r("b-col",[r("b-form-group",{attrs:{"label-cols":"4","label-cols-lg":"4",label:"Ending date","label-for":"end-datepicker"}},[r("b-form-datepicker",{staticClass:"mb-2",attrs:{id:"end-datepicker"}})],1)],1),r("b-col",[r("b-form-group",{attrs:{"label-cols":"4","label-cols-lg":"6",label:"Min cost","label-for":"min-cost"}},[r("b-form-input",{attrs:{id:"min-cost",placeholder:"NE RADI"}})],1)],1),r("b-col",[r("b-form-group",{attrs:{"label-cols":"4","label-cols-lg":"6",label:"Max cost","label-for":"max-cost"}},[r("b-form-input",{attrs:{id:"max-cost",placeholder:"NE RADI"}})],1)],1)],1),r("b-row",[r("b-col",[r("b-form-group",{attrs:{"label-cols":"4","label-cols-lg":"6",label:"Min room numbers","label-for":"min-room-numbers"}},[r("b-form-input",{attrs:{id:"min-room-numbers",placeholder:"Input min rooms"},model:{value:t.minRoomNumber,callback:function(e){t.minRoomNumber=e},expression:"minRoomNumber"}})],1)],1),r("b-col",[r("b-form-group",{attrs:{"label-cols":"4","label-cols-lg":"6",label:"Max room numbers","label-for":"max-room-numbers"}},[r("b-form-input",{attrs:{id:"max-room-numbers",placeholder:"Input max rooms"},model:{value:t.maxRoomNumber,callback:function(e){t.maxRoomNumber=e},expression:"maxRoomNumber"}})],1)],1),""!=t.user?r("b-col",[r("b-form-group",{attrs:{"label-cols":"4","label-cols-lg":"6",label:"Type:","label-for":"input-3"}},[r("b-form-select",{attrs:{id:"input-3",options:t.types},model:{value:t.type,callback:function(e){t.type=e},expression:"type"}})],1)],1):t._e()],1),r("b-row",[""!=t.user?r("b-col",[r("b-button",{on:{click:function(e){return t.sortMethod()}}},[t._v(t._s(t.sortButtonName))])],1):t._e(),"HOST"===t.user.userRole||"ADMIN"===t.user.userRole?r("b-col",[r("b-form-group",{attrs:{"label-cols":"4","label-cols-lg":"6",label:"Apartment status:","label-for":"input-4"}},[r("b-form-select",{attrs:{id:"input-4",options:t.statuses},model:{value:t.status,callback:function(e){t.status=e},expression:"status"}})],1)],1):t._e()],1)],1)],1),r("div",{staticClass:"content"},[r("ul",{staticClass:"ul-content"},t._l(t.filteredApartment,(function(e){return r("li",{key:e.id},[r("div",[r("b-card",{staticClass:"mb-2",staticStyle:{"max-width":"20rem"},attrs:{"img-src":"https://picsum.photos/600/300/?image=25","img-alt":"Image","img-top":"",tag:"article"}},[r("b-card-text",[e.apartmentLocation.adress?r("div",[r("b",[t._v(" "+t._s(e.apartmentLocation.adress.street)+" "+t._s(e.apartmentLocation.adress.number)+" ")]),r("div",[t._v(" "+t._s(e.apartmentLocation.adress.city)+" "+t._s(e.apartmentLocation.adress.postalCode)+" ")]),r("div",[t._v(" "+t._s(e.apartmentLocation.longitude)+" , "+t._s(e.apartmentLocation.latitude)+" ")])]):t._e()]),""!=t.user?r("b-button",[r("router-link",{attrs:{to:"/res"}},[t._v("Open")])],1):t._e()],1)],1)])})),0)])])},U=[],I=(r("4de4"),r("caad"),r("ac1f"),r("2532"),r("466d"),{name:"HomeContentComponent",mounted:function(){var t=this;d.a.get("http://localhost:8080/RACompany/rest/apartment/helloWorld").then((function(e){return t.info=e.data}))},data:function(){return{info:[],user:"",location:"",guestNumber:"",minRoomNumber:"",maxRoomNumber:"",types:["ROOM","FULL",""],type:"",sort:!1,sortButtonName:"Descending order",status:"",statuses:["true","false",""],starting_date:""}},created:function(){var t=this;d.a.get("http://localhost:8080/RACompany/rest/currentUser").then((function(e){return t.user=e.data}))},methods:{sortMethod:function(){return this.sort?(this.sortButtonName="Ascending order",this.sort=!1):(this.sortButtonName="Descending order",this.sort=!0),this.sortButtonName}},computed:{filteredApartment:function(){var t=this,e=this.info;return""!=this.guestNumber&&(e=e.filter((function(e){return String(e.guestNumber).match(t.guestNumber)}))),""!=this.minRoomNumber&&(e=e.filter((function(e){return parseInt(e.roomNumber)>=parseInt(t.minRoomNumber)}))),""!=this.maxRoomNumber&&(e=e.filter((function(e){return parseInt(e.roomNumber)<=parseInt(t.maxRoomNumber)}))),""!=this.location&&(e=e.filter((function(e){if(e.apartmentLocation.adress)return e.apartmentLocation.adress.city.toLowerCase().includes(t.location.toLowerCase())}))),""!=this.type&&(e=e.filter((function(e){return e.type.match(t.type)}))),this.sort&&(e=e.sort((function(t,e){return t.pricePerNight-e.pricePerNight}))),this.sort||(e=e.sort((function(t,e){return e.pricePerNight-t.pricePerNight}))),""!=this.status&&(e=e.filter((function(e){return String(e.apartmentStatus).match(t.status)}))),e}}}),P=I,D=(r("bdb5"),Object(v["a"])(P,S,U,!1,null,"25fd08a2",null)),T=D.exports,M=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{staticClass:"position"},[r("b-form",[r("b-form-group",{attrs:{id:"input-group-1",label:"Password:","label-for":"input-1"}},[r("b-form-input",{attrs:{id:"input-1",type:"password",required:"",placeholder:"Enter password"},model:{value:t.form.password,callback:function(e){t.$set(t.form,"password",e)},expression:"form.password"}})],1),r("b-form-group",{attrs:{id:"input-group-2",label:"Your Username:","label-for":"input-2"}},[r("b-form-input",{attrs:{id:"input-2",required:"",placeholder:"Enter username"},model:{value:t.form.name,callback:function(e){t.$set(t.form,"name",e)},expression:"form.name"}})],1),r("b-form-group",{attrs:{id:"input-group-3",label:"Your firstname:","label-for":"input-2"}},[r("b-form-input",{attrs:{id:"input-2",required:"",placeholder:"Enter firstname"},model:{value:t.form.firstname,callback:function(e){t.$set(t.form,"firstname",e)},expression:"form.firstname"}})],1),r("b-form-group",{attrs:{id:"input-group-3",label:"Your lastname:","label-for":"input-2"}},[r("b-form-input",{attrs:{id:"input-2",required:"",placeholder:"Enter lastname"},model:{value:t.form.lastname,callback:function(e){t.$set(t.form,"lastname",e)},expression:"form.lastname"}})],1),r("b-form-group",{attrs:{id:"input-group-3",label:"Sex:","label-for":"input-3"}},[r("b-form-select",{attrs:{id:"input-3",options:t.sexes,required:""},model:{value:t.form.sex,callback:function(e){t.$set(t.form,"sex",e)},expression:"form.sex"}})],1),r("b-form-group",{attrs:{id:"input-group-3",label:"Role:","label-for":"input-3"}},[r("b-form-select",{attrs:{id:"input-3",options:t.roles,required:""},model:{value:t.form.role,callback:function(e){t.$set(t.form,"role",e)},expression:"form.role"}})],1),r("b-button",{on:{click:function(e){return t.signUp()}}},[t._v(" Register ")])],1)],1)},q=[],H={data:function(){return{form:{password:"",name:"",firstname:"",lastname:"",sex:"",role:"",msg:""},sexes:["Male","Female"],roles:["GUEST","HOST"]}},methods:{signUp:function(){var t=this;return Object(c["a"])(regeneratorRuntime.mark((function e(){var r;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.prev=0,r={username:t.form.name,password:t.form.password,sex:t.form.sex,userRole:t.form.role,firstname:t.form.firstname,lastname:t.form.lastname},e.next=4,f.signUp(r);case 4:t.$router.push("/login"),e.next=10;break;case 7:e.prev=7,e.t0=e["catch"](0),t.form.msg=e.t0.response.data;case 10:case"end":return e.stop()}}),e,null,[[0,7]])})))()}}},V=H,B=(r("c5ba"),Object(v["a"])(V,M,q,!1,null,"4549335a",null)),F=B.exports,G=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",[t.user.userRole===t.admin?r("div",[r("AdminComponent")],1):t.user.userRole===t.guest?r("div",[r("GuestComponent")],1):t._e(),r("div",[r("HostComponent")],1)])},Y=[],J=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",[r("h1",[t._v("Admin Component")]),r("div",{attrs:{id:"tabs"}},[r("b-tabs",{attrs:{"content-class":"mt-3"}},[r("b-tab",{attrs:{title:"Personal Info"}},[r("UserInfoComponent",{attrs:{user:t.user}})],1),r("b-tab",{attrs:{title:"Users"},on:{click:t.getAllUsers}},[r("ViewAllUsers",{attrs:{user:t.user,users:t.users}})],1),r("b-tab",{attrs:{title:"Apartments"},on:{click:t.getAllApartments}},[r("ViewAllApartments",{attrs:{apartments:t.apartments}})],1),r("b-tab",{attrs:{title:"Apartment amenities"},on:{click:t.getAllAmenities}},[r("ViewAllAmenities",{attrs:{amenities:t.amenities}})],1),r("b-tab",{attrs:{title:"Reservations"},on:{click:t.getAllReservations}},[r("ViewAllResevations",{attrs:{reservations:t.reservations}})],1)],1)],1)])},W=[],z=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",[r("h1",[t._v("UserInfoComponent")]),r("div",{staticClass:"position"},[r("b-form",{attrs:{method:"post"},on:{submit:function(e){return e.preventDefault(),t.submintModifiedUser(e)}}},[r("b-form-group",{attrs:{id:"input-group-1",label:"Password:","label-for":"input-1"}},[r("b-form-input",{attrs:{id:"input-1",type:"password",required:"",placeholder:"Enter password"},model:{value:this.user.password,callback:function(e){t.$set(this.user,"password",e)},expression:"this.user.password"}})],1),r("b-form-group",{attrs:{id:"input-group-3",label:"Your firstname:","label-for":"input-3"}},[r("b-form-input",{attrs:{id:"input-3",required:"",placeholder:"Enter firstname"},model:{value:this.user.firstname,callback:function(e){t.$set(this.user,"firstname",e)},expression:"this.user.firstname"}})],1),r("b-form-group",{attrs:{id:"input-group-4",label:"Your lastname:","label-for":"input-4"}},[r("b-form-input",{attrs:{id:"input-4",required:"",placeholder:"Enter lastname"},model:{value:this.user.lastname,callback:function(e){t.$set(this.user,"lastname",e)},expression:"this.user.lastname"}})],1),r("b-form-group",{attrs:{id:"input-group-5",label:"Sex:","label-for":"input-5"}},[r("b-form-select",{attrs:{id:"input-5",options:t.sexes,required:""},model:{value:this.user.sex,callback:function(e){t.$set(this.user,"sex",e)},expression:"this.user.sex"}})],1),r("b-button",{attrs:{type:"submit"}},[t._v(" Submit ")])],1)],1)])},K=[],Q={name:"UserInfoComponent",props:{user:{type:Object,required:!0}},data:function(){return{newUser:{username:"",password:"",firstname:"",lastname:"",sex:""},sexes:["Male","Female"]}},methods:{submintModifiedUser:function(){this.newUser=this.user;var t="http://localhost:8080/rest/users/modify",e=t.concat(this.newUser.username);console.log(e),console.log(this.user),console.log(this.newUser),d.a.post(t,this.newUser).then((function(t){return t})).catch(console.log("modifikacija nije prosla"))}},mounted:function(){console.log(this.user.username)}},X=Q,Z=(r("240f"),Object(v["a"])(X,z,K,!1,null,"4560d2d6",null)),tt=Z.exports,et=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",t._l(this.users,(function(e){return r("b-list-group",{key:e.username},[r("b-list-group-item",{attrs:{button:""}},[t._v(t._s(e.username))])],1)})),1)},rt=[],at={name:"ViewAllUsers",props:{user:{type:Object,required:!0},users:{type:Array}},data:function(){},methods:{getAllUsers:function(){var t=this;d.a.get("http://localhost:8080/rest/users/allUsers").then((function(e){return t.users=e.data})).catch(console.log("greska pri dobavljanju korisnika"))}},mounted:function(){}},nt=at,ot=Object(v["a"])(nt,et,rt,!1,null,"de77feaa",null),st=ot.exports,it=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",[t._l(this.apartments,(function(e){return r("b-list-group",{key:e.id},[r("b-list-group-item",{directives:[{name:"b-modal",rawName:"v-b-modal.modal",modifiers:{modal:!0}}],attrs:{button:""},on:{click:function(r){return t.selectApartment(e)}}},[t._v(t._s(e.id))])],1)})),r("b-modal",{attrs:{id:"modal",scrollable:""}},[r("ApartmentComponent",{attrs:{apartment:t.selectedApartment}})],1)],2)},lt=[],ut=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",[r("b-form",{on:{submit:function(e){return e.preventDefault(),t.onSubmit(e)}}},[r("b-form-group",{attrs:{id:"input-group-1",label:"Apartment id","label-for":"input-1"}},[r("b-form-input",{attrs:{id:"input-1",type:"text",placeholder:"Entert id"},model:{value:t.apartment.id,callback:function(e){t.$set(t.apartment,"id",e)},expression:"apartment.id"}})],1),r("b-form-group",{attrs:{id:"input-group-2",label:"Apartment type","label-for":"input-2"}},[r("b-form-select",{attrs:{id:"input-2",options:t.types,required:""},model:{value:t.apartment.type,callback:function(e){t.$set(t.apartment,"type",e)},expression:"apartment.type"}})],1),r("b-form-group",{attrs:{id:"input-group-3",label:"Number of rooms","label-for":"input-3"}},[r("b-form-input",{attrs:{id:"input-3",type:"number",placeholder:"Entert number of rooms"},model:{value:t.apartment.roomNumber,callback:function(e){t.$set(t.apartment,"roomNumber",e)},expression:"apartment.roomNumber"}})],1),r("b-form-group",{attrs:{id:"input-group-4",label:"Number of guests","label-for":"input-4"}},[r("b-form-input",{attrs:{id:"input-4",type:"number",placeholder:"Entert number of guests"},model:{value:t.apartment.guestNumber,callback:function(e){t.$set(t.apartment,"guestNumber",e)},expression:"apartment.guestNumber"}})],1),r("b-form-group",{attrs:{id:"input-group-5",label:"Location","label-for":"input-5"}},[r("LocationComponent",{attrs:{apartmentLocation:t.apartment.apartmentLocation,id:"input-5"}})],1),r("b-form-group",{attrs:{id:"input-group-6",label:"Available dates","label-for":"input-6"}},[r("b-calendar",{attrs:{id:"input-6"}})],1),r("b-form-group",{attrs:{id:"input-group-7",label:"Price per night","label-for":"input-7"}},[r("b-form-input",{attrs:{id:"input-7",type:"number",step:"0.0001",placeholder:"Entert price per night"},model:{value:t.apartment.pricePerNight,callback:function(e){t.$set(t.apartment,"pricePerNight",e)},expression:"apartment.pricePerNight"}})],1),r("b-form-group",{attrs:{id:"input-group-8",label:"Check in time","label-for":"input-8"}},[r("b-time",{attrs:{id:"input-8",locale:"en"},model:{value:t.apartment.checkInTime,callback:function(e){t.$set(t.apartment,"checkInTime",e)},expression:"apartment.checkInTime"}})],1),r("b-form-group",{attrs:{id:"input-group-9",label:"Check out time","label-for":"input-9"}},[r("b-time",{attrs:{id:"input-9",locale:"en"},model:{value:t.apartment.checkOutTime,callback:function(e){t.$set(t.apartment,"checkOutTime",e)},expression:"apartment.checkOutTime"}})],1),r("b-form-group",{attrs:{id:"input-group-10",label:"Apartment amenities","label-for":"input-10"}},[r("b-button",{attrs:{type:"primary"}},[t._v("Choose amenities")]),r("div",t._l(this.amenities,(function(e){return r("b-list-group",{key:e.id},[r("input",{attrs:{type:"checkbox",id:e.id,name:"CheckBoxInputName"},on:{click:function(r){return t.checkBoxClicked(e,r)}}}),r("b-list-group-item",{attrs:{label:"",for:e.id}},[t._v(t._s(e.name))])],1)})),1),r("ListAmenitiesComponent",{attrs:{id:"input-10"}})],1),r("b-form-group",{attrs:{id:"input-group-11",label:"Apartment status","label-for":"input-11"}},[r("b-form-radio",{attrs:{name:"some-radios",value:"true"},model:{value:t.apartment.apartmentStatus,callback:function(e){t.$set(t.apartment,"apartmentStatus",e)},expression:"apartment.apartmentStatus"}},[t._v("Active")]),r("b-form-radio",{attrs:{name:"some-radios",value:"false"},model:{value:t.apartment.apartmentStatus,callback:function(e){t.$set(t.apartment,"apartmentStatus",e)},expression:"apartment.apartmentStatus"}},[t._v("Not-Active")])],1),r("b-form-group",{attrs:{id:"input-group-12",lable:"Apartment pictures","label-for":"input-12"}},[r("input",{attrs:{id:"input-group-12",type:"file",multiple:"",accept:"image/*"},on:{change:t.chooseImages}})]),r("b-form-group",{attrs:{id:"submitBtn"}},[r("b-button",{attrs:{type:"submit"}},[t._v(" Submit")])],1)],1)],1)},mt=[],ct=(r("a434"),function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",[r("b-form",[r("b-form-group",{attrs:{id:"location-input-group-1",label:"Location longitude","label-for":"input-longitude"}},[r("b-form-input",{attrs:{id:"input-longitude",type:"number",step:"0.000001",placeholder:"Entert longitude"},model:{value:t.apartmentLocation.longitude,callback:function(e){t.$set(t.apartmentLocation,"longitude",e)},expression:"apartmentLocation.longitude"}})],1),r("b-form-group",{attrs:{id:"location-input-group-2",label:"Location latitude","label-for":"input-latitude"}},[r("b-form-input",{attrs:{id:"input-latitude",type:"number",step:"0.000001",placeholder:"Entert latitude"},model:{value:t.apartmentLocation.latitude,callback:function(e){t.$set(t.apartmentLocation,"latitude",e)},expression:"apartmentLocation.latitude"}})],1),r("b-form-group",{attrs:{id:"location-input-group-3",label:"Adress","label-for":"input-adress"}},[r("AdressComponent",{attrs:{adress:t.apartmentLocation.adress}})],1)],1)],1)}),pt=[],dt=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",[r("b-form",[r("b-form-group",{attrs:{id:"adress-input-group-1",label:"Adress city","label-for":"input-city"}},[r("b-form-input",{attrs:{id:"input-city",type:"text",placeholder:"Entert city"},model:{value:t.adress.city,callback:function(e){t.$set(t.adress,"city",e)},expression:"adress.city"}})],1),r("b-form-group",{attrs:{id:"adress-input-group-2",label:"Adress street","label-for":"input-street"}},[r("b-form-input",{attrs:{id:"input-street",type:"text",placeholder:"Entert street"},model:{value:t.adress.street,callback:function(e){t.$set(t.adress,"street",e)},expression:"adress.street"}})],1),r("b-form-group",{attrs:{id:"adress-input-group-3",label:"Street number","label-for":"input-number"}},[r("b-form-input",{attrs:{id:"input-adress",type:"number",placeholder:"Entert number of rooms"},model:{value:t.adress.number,callback:function(e){t.$set(t.adress,"number",e)},expression:"adress.number"}})],1),r("b-form-group",{attrs:{id:"adress-input-group-4",label:"Postal code","label-for":"input-postalCode"}},[r("b-form-input",{attrs:{id:"input-postalCode",type:"number",placeholder:"Entert postal code"},model:{value:t.adress.postalCode,callback:function(e){t.$set(t.adress,"postalCode",e)},expression:"adress.postalCode"}})],1)],1)],1)},bt=[],ft={props:{adress:{type:Object}},methods:{output:function(){this.$emit("input",this.apartmentLocation)}}},gt=ft,ht=Object(v["a"])(gt,dt,bt,!1,null,"557ac49f",null),vt=ht.exports,yt={components:{AdressComponent:vt},props:{apartmentLocation:{type:Object}},methods:{output:function(){this.$emit("input",this.apartmentLocation)}}},At=yt,xt=Object(v["a"])(At,ct,pt,!1,null,"0303f201",null),kt=xt.exports,_t=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div")},Ct=[],wt={},Nt=wt,$t=Object(v["a"])(Nt,_t,Ct,!1,null,"32866804",null),Rt=$t.exports,Ot={components:{LocationComponent:kt,ListAmenitiesComponent:Rt},props:{apartment:{type:Object}},data:function(){return{types:["FULL","ROOM"],amenities:[{id:1,name:"name"},{id:2,name:"name"}],images:[]}},methods:{onSubmit:function(t){t.prevent,this.uploadImages(),console.log(this.apartment)},checkBoxClicked:function(t,e){var r={id:t.id,name:t.name};if(e.target.checked)this.apartment.amenities.push(r);else for(var a in this.apartment.amenities)this.apartment.amenities[a].id===r.id&&this.apartment.amenities.splice(a,1)},chooseImages:function(t){for(var e=t.target.files.length,r=0;r<e;r++)this.images.push(t.target.files[r])},uploadImages:function(){for(var t in this.images)this.apartment.imageSource.push(this.images[t].name)}},created:function(){}},Et=Ot,Lt=Object(v["a"])(Et,ut,mt,!1,null,"41a6dfa0",null),jt=Lt.exports,St={name:"ViewAllApartments",props:{apartments:{type:Array,required:!0}},components:{ApartmentComponent:jt},data:function(){return{selectedApartment:{}}},methods:{selectApartment:function(t){this.selectedApartment=t}}},Ut=St,It=Object(v["a"])(Ut,it,lt,!1,null,"61111e00",null),Pt=It.exports,Dt=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",[t._l(this.amenities,(function(e){return r("b-list-group",{key:e.id},[r("b-list-group-item",{directives:[{name:"b-modal",rawName:"v-b-modal.modal",modifiers:{modal:!0}}],attrs:{button:""},on:{click:function(r){return t.showAmenity(e)}}},[t._v(t._s(e.id))])],1)})),r("div",[r("b-button",{directives:[{name:"b-modal",rawName:"v-b-modal.modal",modifiers:{modal:!0}}],on:{click:t.createNewAmenity}},[t._v("Create new Amenity")])],1),r("b-modal",{attrs:{id:"modal"}},[r("AmenityComponent",{attrs:{amenity:t.selectedAmenity}})],1)],2)},Tt=[],Mt=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",[r("b-form",{on:{submit:function(e){return e.preventDefault(),t.onSubmit(e)}}},[r("b-form-group",{attrs:{id:"input-group-1",label:"Apratment amenity id","label-for":"input-1"}},[r("b-form-input",{directives:[{name:"modal",rawName:"v-modal",value:t.amenity.id,expression:"amenity.id"}],attrs:{id:"input-1",type:"number",placeholder:"Entert id"}})],1),r("b-form-group",{attrs:{id:"input-group-2",label:"Apratment amenity name","label-for":"input-2"}},[r("b-form-input",{directives:[{name:"modal",rawName:"v-modal",value:t.amenity.name,expression:"amenity.name"}],attrs:{id:"input-2",type:"text",placeholder:"Entert name"}})],1),r("b-form-group",{attrs:{id:"submitBtn"}},[r("b-button",{attrs:{type:"submit"}},[t._v(" Submit ")])],1)],1)],1)},qt=[],Ht={props:{amenity:{type:Object}},methods:{onSubmit:function(){console.log(this.amenity)}}},Vt=Ht,Bt=Object(v["a"])(Vt,Mt,qt,!1,null,"63a0b2a6",null),Ft=Bt.exports,Gt={name:"ViewAllAmenities",props:{amenities:{type:Array}},components:{AmenityComponent:Ft},data:function(){return{selectedAmenity:{}}},methods:{showAmenity:function(t){this.selectedAmenity=t},createNewAmenity:function(){var t={id:"",name:""};this.selectedAmenity=t}}},Yt=Gt,Jt=Object(v["a"])(Yt,Dt,Tt,!1,null,"30bf7164",null),Wt=Jt.exports,zt=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div")},Kt=[],Qt={name:"ViewAllReservations",props:{reservations:{type:Array}}},Xt=Qt,Zt=Object(v["a"])(Xt,zt,Kt,!1,null,"4c2a2238",null),te=Zt.exports,ee={name:"AdminComponent",components:{UserInfoComponent:tt,ViewAllUsers:st,ViewAllApartments:Pt,ViewAllAmenities:Wt,ViewAllResevations:te},data:function(){return{user:{},users:[],apartments:[],amenities:[],reservations:[]}},methods:{getCurrUser:function(){var t=this;d.a.get("http://localhost:8080/RACompany/rest/currentUser").then((function(e){return t.user=e.data})).catch(console.log("nema ulogovanog")),console.log(this.user)},getAllUsers:function(){var t=this;d.a.get("http://localhost:8080/RACompany/rest/users/allUsers").then((function(e){return t.users=e.data})).catch(console.log("greska pri dobavljanju korisnika"))},getAllApartments:function(){var t=this;d.a.get("http://localhost:8080/RACompany/rest/apartment/all").then((function(e){return t.apartments=e.data}))},getAllAmenities:function(){var t=this;d.a.get("http://localhost:8080/RACompany/rest/amneities/all").then((function(e){return t.amenities=e.data}))},getAllReservations:function(){}},mounted:function(){this.getCurrUser(),console.log(this.user.username)}},re=ee,ae=Object(v["a"])(re,J,W,!1,null,"18322ddc",null),ne=ae.exports,oe=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",[r("h1",[t._v("Guest Component")]),r("div",[r("b-tabs",[r("b-tab",{attrs:{title:"Personal info"}},[r("UserInfoComponent",{attrs:{user:t.user}})],1),r("b-tab",{attrs:{title:"Reservations"}},[r("p",[t._v("Yours reservations")])])],1)],1)])},se=[],ie={name:"GuestComponent",components:{UserInfoComponent:tt},data:function(){return{user:{}}}},le=ie,ue=Object(v["a"])(le,oe,se,!1,null,"d883aaa4",null),me=ue.exports,ce=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",[r("h1",[t._v("Host Component")]),r("div",[r("b-tabs",[r("b-tab",{attrs:{title:"Personal Info"}},[r("UserInfoComponent",{attrs:{user:t.user}})],1),r("b-tab",{attrs:{title:"Apartments"},on:{click:t.getAllApartments}},[r("HostApartmentComponents",{attrs:{apartments:t.apartments}})],1),r("b-tab",{attrs:{title:"Reservations"}},[r("HostReservationsComponent")],1)],1)],1)])},pe=[],de=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",[t._l(this.apartments,(function(e){return r("b-list-group",{key:e.id},[r("b-list-group-item",{directives:[{name:"b-modal",rawName:"v-b-modal.modal",modifiers:{modal:!0}}],attrs:{button:""},on:{click:function(r){return t.selectApartment(e)}}},[t._v(t._s(e.id))])],1)})),r("div",[r("b-button",{directives:[{name:"b-modal",rawName:"v-b-modal.modal",modifiers:{modal:!0}}],attrs:{type:"primary"},on:{click:t.createNewApartment}},[t._v("Create new apartment")])],1),r("b-modal",{attrs:{id:"modal",scrollable:""}},[r("ApartmentComponent",{attrs:{apartment:t.selectedApartment}})],1)],2)},be=[],fe={name:"HostApartmentsComponent",components:{ApartmentComponent:jt},props:{apartments:{type:Array}},data:function(){return{selectedApartment:{id:2,type:"",roomNumber:"",guestNumber:"",apartmentLocation:{},apartmentResevartionDates:[],comments:[],pricePerNight:0,checkInTime:"",checkOutTime:"",apartmentStatus:!1,amenities:[],reservations:[],imageSource:[]}}},methods:{selectApartment:function(t){console.log(t),this.selectedApartment=t,console.log(this.selectedApartment)},createNewApartment:function(){var t={id:"",type:"",roomNumber:"",guestNumber:"",apartmentLocation:{},apartmentResevartionDates:[],comments:[],pricePerNight:0,checkInTime:"",checkOutTime:"",apartmentStatus:!1,amenities:[],reservations:[],imageSource:[]};this.selectedApartment=t,this.getAllAmenities()},getAllAmenities:function(){var t=this;d.a.get("http://localhost:8080/RACompany/rest/amneities/all").then((function(e){return t.selectedApartment.amenities=e.data}))}}},ge=fe,he=Object(v["a"])(ge,de,be,!1,null,"1a816a4e",null),ve=he.exports,ye=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div")},Ae=[],xe={},ke=xe,_e=Object(v["a"])(ke,ye,Ae,!1,null,"b067ea88",null),Ce=_e.exports,we={name:"HostComponent",components:{UserInfoComponent:tt,HostApartmentComponents:ve,HostReservationsComponent:Ce},data:function(){return{user:{},apartments:[{id:1,type:"FULL",roomNumber:"",guestNumber:"",apartmentLocation:{longitude:25.478,latitude:24.486,adress:{city:"Novi Sad",street:"Lasla Gala",postalCode:"21000",number:3}},apartmentResevartionDates:[],comments:[],pricePerNight:0,checkInTime:"",checkOutTime:"",apartmentStatus:!1,amenities:[],reservations:[],imageSource:[]}]}},methods:{getAllApartments:function(){var t=this,e="http://localhost:8080/rest/apartment/hostAll/",r=e.concat(this.user.username);d.a.get(r).then((function(e){return t.apartments=e.data})).catch(console.log("greska pri dobavljanju apartmana"))}}},Ne=we,$e=Object(v["a"])(Ne,ce,pe,!1,null,"15b8e2ae",null),Re=$e.exports,Oe={name:"User",components:{AdminComponent:ne,GuestComponent:me,HostComponent:Re},created:function(){var t=this;d.a.get("http://localhost:8080/RACompany/rest/currentUser").then((function(e){return t.user=e.data})).catch(console.log("nesto"))},data:function(){return{user:"",admin:"ADMIN",guest:"GUEST",host:"HOST"}}},Ee=Oe,Le=Object(v["a"])(Ee,G,Y,!1,null,"67d20112",null),je=Le.exports,Se=function(){var t=this,e=t.$createElement;t._self._c;return t._m(0)},Ue=[function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",[r("h1",[t._v("Reservation Page")])])}],Ie={name:"ReservationPage"},Pe=Ie,De=Object(v["a"])(Pe,Se,Ue,!1,null,"250e63c3",null),Te=De.exports;a["default"].use(w["a"]);var Me=[{path:"/",name:"HomeContentComponent",component:T},{path:"/user",name:"User",component:je},{path:"/login",name:"LogInPage",component:j},{path:"/reg",name:"RegisterPage",component:F},{path:"/res",name:"ReservationPage",component:Te}],qe=new w["a"]({mode:"history",base:"/RACompany/",routes:Me}),He=qe,Ve=r("5f5b");r("f9e3"),r("2dd8");a["default"].use(Ve["a"]),a["default"].use(o.a),a["default"].use(s["b"],{dayNames:["Mo","Tu","We","Th","Fr","Sa","Su"]}),a["default"].config.productionTip=!1,new a["default"]({router:He,render:function(t){return t(C)}}).$mount("#app")},7092:function(t,e,r){},9902:function(t,e,r){},a911:function(t,e,r){"use strict";var a=r("7092"),n=r.n(a);n.a},bdb5:function(t,e,r){"use strict";var a=r("c573"),n=r.n(a);n.a},c573:function(t,e,r){},c5ba:function(t,e,r){"use strict";var a=r("177c"),n=r.n(a);n.a}});
//# sourceMappingURL=app.107f8ff1.js.map