find . -name .DS_Store -print0 | xargs -0 git rm --ignore-unmatch
