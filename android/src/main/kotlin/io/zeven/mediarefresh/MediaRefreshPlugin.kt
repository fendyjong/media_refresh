package io.zeven.mediarefresh

import android.media.MediaScannerConnection
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.PluginRegistry.Registrar

class MediaRefreshPlugin private constructor(private val mRegistrar: Registrar) : MethodCallHandler {
	private val registrar: Registrar? = null

	companion object {
		@JvmStatic
		fun registerWith(registrar: Registrar): Unit {
			val channel = MethodChannel(registrar.messenger(), "media_refresh")
			channel.setMethodCallHandler(MediaRefreshPlugin(registrar))
		}
	}

	override fun onMethodCall(call: MethodCall, result: Result): Unit {
		when (call.method) {
			"scanFile" -> {
				val url: String = call.argument("url")
				MediaScannerConnection.scanFile(mRegistrar.context(), arrayOf(url), null, null)
				result.success(true)
			}
			else -> result.notImplemented()
		}

		/*
		if (call.method.equals("getPlatformVersion")) {
			result.success("Android ${android.os.Build.VERSION.RELEASE}")
		} else {
			result.notImplemented()
		}
		*/
	}
}
