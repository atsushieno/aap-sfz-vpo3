package org.androidaudioplugin.sfz.vpo3

import org.androidaudioplugin.sfz.AssetSfzResourceService

class Vpo3Service : AssetSfzResourceService() {
    override val instruments: List<Instrument> by lazy {
        // Only public entry points: libs contains shared includes and samples.
        listOf("Brass", "Keys", "Percussion", "Strings", "Vocals", "Woodwinds")
            .flatMap { family ->
                assets.list("vpo3/$family").orEmpty()
                    .filter { it.endsWith(".sfz", ignoreCase = true) }
                    .sorted()
                    .map { name ->
                        val path = "$family/$name"
                        Instrument(path, "VPO3 / $family / ${name.removeSuffix(".sfz")}",
                            "3", "vpo3", path, listOf(family, "libs"))
                    }
            }
    }
}
