import { Directive, EventEmitter, HostBinding, HostListener, Output } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { FileHandle } from './models/file-handle.model'

@Directive({
  selector: '[appDrag]'
})
export class DragDirective {

  @Output() files : EventEmitter<FileHandle> = new EventEmitter();

  @HostBinding("style.background") private background = "#eee";
  constructor(private sanitizer: DomSanitizer) { }

  @HostListener("dragover",["$event"])
  public OnDragOver(evt: DragEvent){
    evt.preventDefault();
    evt.stopPropagation();
    this.background = "#999";
  }

  @HostListener("dragleave",["$event"])
  public OndragLeave(evt: DragEvent){
    evt.preventDefault();
    evt.stopPropagation();
    this.background = "#eee";
  }

  @HostListener("drop",["$event"])
  public OnDrop(evt: DragEvent){
    evt.preventDefault();
    evt.stopPropagation();
    this.background = "#eee";

    let fileHandle : FileHandle;


    if(evt.dataTransfer != undefined){
      const file = evt.dataTransfer.files[0];
      const url = this.sanitizer.bypassSecurityTrustUrl(window.URL.createObjectURL(file))
 
    fileHandle = {file, url};
    this.files.emit(fileHandle)
  }
    
  }

}
