# native summary IR

1. Type system is currently unused. backend uses an analysis to find the soot type.
2. All `CallXXXMethodA/CallXXXMethodV` should be converted to non A/V varient before generate to IR.

### Function

It's possible that clazz is null.
1. dynamic registered function(registeredBy != null). because clazz resolution is delayed.
2. JNI_OnLoad. this normally will not be converted to actual java function.
