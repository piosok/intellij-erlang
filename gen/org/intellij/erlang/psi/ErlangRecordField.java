// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;

public interface ErlangRecordField extends ErlangCompositeElement {

  @Nullable
  ErlangExpression getExpression();

  @NotNull
  List<ErlangQAtom> getQAtomList();

  @Nullable
  PsiReference getReference();

  @NotNull
  ErlangQAtom getFieldNameAtom();

}
