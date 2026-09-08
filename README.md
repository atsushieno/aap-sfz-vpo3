# Virtual Playing Orchestra 3 resource APK

aap-sfz-vpo3 provides [Virtual Playing Orchestra 3](http://virtualplaying.com/virtual-playing-orchestra/) as a separate installable SFZ resource package for the provisional
`org.androidaudioplugin.SfzResourceService.V1` contract. Install it alongside the
resource-enabled aap-lv2-sfizz app, open its SFZ picker, and select Find SFZ packs.
All six instrument families share the original `libs` sample tree, served through
read-only APK descriptor ranges without extracting samples; SFZ paths and sample
bytes are preserved. The source documentation and license files are included. A
minimal Compose launcher activity displays the package name.

Assets are packaged directly through `app/src/main/assets/vpo3`, which links to
the checked-out `external/Virtual_Playing_Orchestra_3` submodule. No external
source path or staging task is needed. Output:
`app/build/outputs/apk/release/app-release-unsigned.apk`.
Signing is required before Android installation and is intentionally not configured.
The package ID is `org.androidaudioplugin.sfz.vpo3`.

Increment the service revision and APK version when changing the packaged data.

## Licenses

Code files in aap-sfz-vpo3 is released under the MIT license.

Virtual Playing Orchestra 3 (submoduled in this repository) is a compilation of freely licensed sample libraries released under a mix of Creative Commons licenses (CC Sampling Plus 1.0, CC Attribution-ShareAlike 3.0, CC Attribution-ShareAlike 4.0 and CC0 1.0) that vary by source library. See `external/Virtual_Playing_Orchestra_3/Documentation/license.htm` and the individual SFZ files for details.
