package org.androidaudioplugin.sfz.vpo3

import android.net.Uri
import android.os.SystemClock
import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import org.androidaudioplugin.soundpack.testkit.ProviderConformance
import org.junit.Assert.assertEquals
import org.junit.Test

/** Reads the pack from the separate test APK, so every call crosses processes. */
class ProviderTest {
    private val context = InstrumentationRegistry.getInstrumentation().context
    private val authority = "org.androidaudioplugin.sfz.vpo3.soundpack.sfz"
    private val pack = "content://$authority/packs/org.studiorack.vpo3"

    @Test
    fun conformsToTheSoundpackContract() {
        ProviderConformance(context, authority).assertConforms()
    }

    /** The Phase 1 gate in soundpack-provider-for-android: the whole catalogue in one query. */
    @Test
    fun listsEveryInstrumentInOneQuery() {
        val started = SystemClock.elapsedRealtime()
        val entries = context.contentResolver.query(Uri.parse("$pack/entries"), null, null, null, null)!!.use { it.count }
        val files = context.contentResolver.query(Uri.parse("$pack/files"), null, null, null, null)!!.use { it.count }
        Log.i("Vpo3ProviderTest", "$entries entries, $files files, listed in ${SystemClock.elapsedRealtime() - started} ms")
        assertEquals(454, entries)
    }
}
