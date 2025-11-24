package com.kmpstudy.data.network.client

import io.ktor.resources.Resource
import kotlinx.serialization.Serializable


//@Serializable
//@Resource("/auth")
//class AuthResource() {
//
//    @Serializable
//    @Resource("/login")
//    class LoginResource(val parent: AuthResource = AuthResource())
//
//    @Serializable
//    @Resource("/register")
//    class RegisterResource(val parent: AuthResource = AuthResource())
//
//    @Serializable
//    @Resource("/check-email")
//    class CheckEmailResource(val parent: AuthResource = AuthResource())
//
//    @Serializable
//    @Resource("/send-verification-code")
//    class SendVerificationCodeResource(val parent: AuthResource = AuthResource())
//
//    @Serializable
//    @Resource("/logout")
//    class LogoutResource(val parent: AuthResource = AuthResource())
//
//    @Serializable
//    @Resource("/verification-code")
//    class VerificationCodeResource(val parent: AuthResource = AuthResource())
//
//
//    @Serializable
//    @Resource("/refresh")
//    class RefreshTokenResource(val parent: AuthResource = AuthResource())
//
//    @Serializable
//    @Resource("/reset-password")
//    class ResetPasswordResource(val parent: AuthResource = AuthResource())
//}
//
//@Serializable
//@Resource("/sleep-tracker")
//class SleepTrackerResource {
//
//    @Serializable
//    @Resource("/records")
//    class RecordsResource(val parent: SleepTrackerResource = SleepTrackerResource())
//
//    @Serializable
//    @Resource("/record/add")
//    class AddRecordResource(val parent: SleepTrackerResource = SleepTrackerResource())
//
//    @Serializable
//    @Resource("/record/update")
//    class UpdateRecordResource(val parent: SleepTrackerResource = SleepTrackerResource())
//
//    @Serializable
//    @Resource("/record/delete")
//    class DeleteRecordResource(val parent: SleepTrackerResource = SleepTrackerResource())
//}
//
//@Serializable
//@Resource("/profile")
//class ProfileResource {
//
//    @Serializable
//    @Resource("/info")
//    class InfoResource(val parent: ProfileResource = ProfileResource())
//
//    @Serializable
//    @Resource("/update/nickname")
//    class UpdateNicknameResource(val parent: ProfileResource = ProfileResource())
//
//    @Serializable
//    @Resource("/update/gender")
//    class UpdateGenderResource(val parent: ProfileResource = ProfileResource())
//
//    @Serializable
//    @Resource("/update/avatar")
//    class UpdateAvatarResource(val parent: ProfileResource = ProfileResource())
//
//    @Serializable
//    @Resource("/update/email")
//    class UpdateEmailResource(val parent: ProfileResource = ProfileResource())
//
//    @Serializable
//    @Resource("/update/password")
//    class UpdatePasswordResource(val parent: ProfileResource = ProfileResource())
//
//    @Serializable
//    @Resource("/delete")
//    class DeleteProfileResource(val parent: ProfileResource = ProfileResource())
//
//}
//
//@Serializable
//@Resource("/devices")
//class DeviceResource {
//
//    @Serializable
//    @Resource("/register")
//    class Register(val parent: DeviceResource = DeviceResource())
//
////    @Serializable
////    @Resource("/heartbeat")
////    class Heartbeat(val parent: DeviceResource)
////
////    @Serializable
////    @Resource("/list")
////    class ListDevices(val parent: DeviceResource)
////
////    @Serializable
////    @Resource("/revoke")
////    class Revoke(val parent: DeviceResource)
//}
