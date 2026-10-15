# Virtual Playing Orchestra 3 resource APK

aap-sfz-vpo3 provides [StudioRack's compact Virtual Playing Orchestra](https://github.com/studiorack/virtual-playing-orchestra) as an SFZ soundpack for Android apps, through the soundpack contract of soundpack-provider-for-android. Apps that use the soundpack client library, such as aap-lv2-sfizz, find it once it is installed. Its 454 instruments are the SFZ files directly inside the six family folders. They share the original `libs` sample tree, served as read-only descriptor ranges of the APK without extracting samples; SFZ paths and sample bytes are preserved. The source documentation and license files are included. A minimal Compose launcher activity displays the package name.

Version 2.0 replaces the provisional `org.androidaudioplugin.SfzResourceService.V1` contract of 1.x. This is a clean break: install it together with an aap-lv2-sfizz that uses the soundpack libraries. Instruments saved with 1.x restore as unavailable.

Assets are packaged directly through `app/src/main/assets/vpo3`, which links to
the checked-out `external/Virtual_Playing_Orchestra_3` submodule. This fork uses
FLAC-encoded samples to reduce the packaged sample-set size. No external
source path or staging task is needed. Output:
`app/build/outputs/apk/release/app-release-unsigned.apk`.
Signing is required before Android installation and is intentionally not configured.
The package ID is `org.androidaudioplugin.sfz.vpo3`.

## Build

Until the soundpack libraries are released, publish them to Maven Local first:

```sh
(cd soundpack-provider-for-android && ./gradlew publishToMavenLocal)
./gradlew assembleRelease
```

The pack is declared in `app/src/main/res/xml/soundpack_sfz.xml` (pack id `org.studiorack.vpo3`). Bump its revision and the APK version whenever the packaged data changes, because saved projects pin the revision. Apps save `commons-soundpack://sfz/org.studiorack.vpo3/<Family>/<file>.sfz?rev=3`.

The device test runs the contract's conformance checks from a separate test APK, and lists the whole catalogue in one query:

```sh
./gradlew connectedDebugAndroidTest
```

## Licenses

Code files in aap-sfz-vpo3 is released under the MIT license.

Virtual Playing Orchestra 3 (submoduled from [StudioRack's compact fork](https://github.com/studiorack/virtual-playing-orchestra)) is a compilation of freely licensed sample libraries released under a mix of Creative Commons licenses (CC Sampling Plus 1.0, CC Attribution-ShareAlike 3.0, CC Attribution-ShareAlike 4.0 and CC0 1.0) that vary by source library. See `external/Virtual_Playing_Orchestra_3/Documentation/license.htm` and the individual SFZ files for details.
